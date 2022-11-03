package mx.tec.multilenguages

import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etTypeHere = findViewById<EditText>(R.id.etTypeHere)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnAlertDialog = findViewById<Button>(R.id.btnAlertDialog)
        val btnLog = findViewById<Button>(R.id.btnLog)
        val btnChangeLanguage = findViewById<Button>(R.id.btnChangeLanguage)

        btnChangeLanguage.setOnClickListener{
            val language = if (resources.configuration.locale.language == "es") "en" else "es"
            val locale = Locale(language)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
            recreate()

            /*val config = resources.configuration
            val lang = "values" // your language code
            val locale = Locale(lang)
            Locale.setDefault(locale)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                config.setLocale(locale)
            else
                config.locale = locale

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                createConfigurationContext(config)
            resources.updateConfiguration(config, resources.displayMetrics)

            this.setContentView(R.layout.activity_main)*/
        }

        /*val spLanguage = findViewById<Spinner>(R.id.spLanguage)
        val data = listOf("Spanish", "Frances")

        val adapter = ArrayAdapter<String>(
            this@MainActivity,

            //get resources from SDK, design from library
            android.R.layout.simple_list_item_1,
            data
        )

        spLanguage.adapter = adapter

        // parent = a ListView, view = screen size
        lvList.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                1 -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Touch one item", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }*/

        // Toast
        btnToast.setOnClickListener{
            Toast.makeText(this@MainActivity, etTypeHere.text, Toast.LENGTH_LONG).show();
        }

        btnAlertDialog.setOnClickListener {
            // AlertDialog
            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle(R.string.alert_dialog_title)
                .setMessage(etTypeHere.text)
                .setPositiveButton(R.string.alert_dialog_positive_button, {dialog, button -> dialog.dismiss()})
                .setNeutralButton(R.string.alert_dialog_neutral_button, {dialog, button -> dialog.dismiss()})
                .setNegativeButton(R.string.alert_dialog_negative_button, {dialog, button -> dialog.dismiss()})
                .show()
            // R.string.app_name
        }

        btnLog.setOnClickListener {
            // Log
            Log.e("ERROR", "${etTypeHere.text}")
            Log.i("INFO", "${etTypeHere.text}")
        }
    }
}