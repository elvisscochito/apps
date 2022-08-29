package mx.tec.multilenguages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTypeHere = findViewById<EditText>(R.id.etTypeHere)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnAlertDialog = findViewById<Button>(R.id.btnAlertDialog)
        val btnLog = findViewById<Button>(R.id.btnLog)

        // Toast
        btnToast.setOnClickListener{
            Toast.makeText(this@MainActivity, etTypeHere.text, Toast.LENGTH_LONG).show();
        }

        btnAlertDialog.setOnClickListener {
            // AlertDialog
            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle(R.string.open)
                .setMessage(etTypeHere.text)
                .setPositiveButton("Ok", {dialog, button -> dialog.dismiss()})
                .setNeutralButton("Later", {dialog, button -> dialog.dismiss()})
                .setNegativeButton("Close", {dialog, button -> dialog.dismiss()})
                .show()
            // R.string.app_name
        }

        btnLog.setOnClickListener{
            // Log
            Log.e("ERROR", "${etTypeHere.text}")
            Log.i("INFO", "${etTypeHere.text}")
        }
    }









}