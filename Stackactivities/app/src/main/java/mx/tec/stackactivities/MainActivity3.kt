package mx.tec.stackactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btn3 = findViewById<Button>(R.id.btn3)

        btn3.setOnClickListener{
            val intent = Intent(this@MainActivity3, MainActivity4::class.java)
            startActivity(intent)
        }
    }
}