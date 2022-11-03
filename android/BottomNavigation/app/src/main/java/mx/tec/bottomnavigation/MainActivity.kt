package mx.tec.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            return
        }

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        // Default Fragment
        fragmentTransaction.replace(R.id.fragmentContainerView, HomeFragment())
        fragmentTransaction.commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Handle home click
                    /*fragmentTransaction.replace(R.id.llContainerView, HomeFragment())
                    fragmentTransaction.commit()*/
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, HomeFragment())
                        // backstack
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.nav_search -> {
                    // Handle home click
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, SearchFragment())
                        // backstack
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    // Handle home click
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, ProfileFragment())
                        // backstack
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }

    /*@Override
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }*/
}