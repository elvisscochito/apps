package mx.tec.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.api.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main2)
        setContentView(binding.root)
    }
}