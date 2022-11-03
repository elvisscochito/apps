package mx.tec.permissionsgps

import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.jar.Manifest

class MainActivity : AppCompatActivity(), LocationListener {
    lateinit var locationManager: LocationManager
    lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this@MainActivity)
        }

        /*map declaration*/
        var mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            map = googleMap
            map.isMyLocationEnabled = true

            /*know last location*/
            /*var location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)*/

            /*init map*/
            var pin: LatLng = LatLng(-34.0,151.0)
            map.addMarker(MarkerOptions().position(pin).title("Marcador"))

            map.moveCamera(CameraUpdateFactory.newLatLng(pin))
        }
    }

    val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->



        /*if (isGranted) {
            // Permission is granted. Continue the action or workflow in your
            // app.

        } else {
            // Explain to the user that the feature is unavailable because
            // the features requires a permission that the user has denied.
            // At the same time, respect the user's decision. Don't link to
            // system settings in an effort to convince the user to change
            // their decision.
        }*/

//        val message = if (isGranted) "Permission granted" else "Permission denied"

        val message =  when {
            isGranted -> "Permission granted"
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                    shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION) -> "Permission explained"
            else -> "Permission denied and don't ask again"
        }
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLocationChanged(location: Location) {
        Toast.makeText(this@MainActivity, location.latitude.toString(), Toast.LENGTH_SHORT).show()
    }
}