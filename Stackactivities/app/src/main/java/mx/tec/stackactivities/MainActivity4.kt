package mx.tec.stackactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener{
            val intent = Intent(this@MainActivity4, MainActivity::class.java)

            // finish() remove last one or CLEAR_TOP go to a specific activity and remove info thought activities
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}