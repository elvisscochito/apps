package mx.tec.interfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // get datatype
        val user = intent.getStringExtra("user")
        val password = intent.getStringExtra("password")

        val tvDisplayUser = findViewById<TextView>(R.id.tvDisplayUser)
        val tvDisplayPassword = findViewById<TextView>(R.id.tvDisplayPassword)
        val tvDisplayMessage = findViewById<TextView>(R.id.tvDisplayMessage)

        tvDisplayUser.text = user
        tvDisplayPassword.text = password

        if (tvDisplayUser.text.toString() == "Elviss" && tvDisplayPassword.text.toString() == "1234") {
            tvDisplayMessage.text = "Success Sign In"
        } else {
            tvDisplayUser.text = ""
            tvDisplayPassword.text = ""
            tvDisplayMessage.text = "Wrong username or password"
        }

        // textview.text = "$user $password" like js string literals
    }
}