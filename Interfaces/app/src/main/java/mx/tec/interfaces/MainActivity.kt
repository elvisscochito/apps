package mx.tec.interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

/*Activity <- AppCompactActivity*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*display design of XML*/
        setContentView(R.layout.activity_main)

        /*same name as id, R means all sources registered in the app */
        val edtEmailUsername = findViewById<EditText>(R.id.edtEmailUsername)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnSignIn)
        val btnLogOut = findViewById<Button>(R.id.btnLogOut)
        val tvForgotPassword = findViewById<TextView>(R.id.tvForgotPassword)

        // getter
        edtEmailUsername.text

        // setter (but only text not allow this)
        edtEmailUsername.setText("Elviss")
        // btnLogin.text = "Aa"

        btnLogin.setOnClickListener {
            // Like alert in js but without buttons, this with the name function(one file per view)
            Toast.makeText(this@MainActivity, edtEmailUsername.text, Toast.LENGTH_SHORT).show()

            // From, to, works like a launcher (omit new keyword thanks to kotlin syntax)
            val intent = Intent(this@MainActivity, Home::class.java)

            // send info, toString() solo edit text
            intent.putExtra("user", edtEmailUsername.text.toString())
            intent.putExtra("password", edtPassword.text.toString())

            // Go to next activity
            startActivity(intent)
        }

        btnLogOut.setOnClickListener {
            finish()
            /*android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(0);*/
        }
    }
}