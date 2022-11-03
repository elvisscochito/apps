package mx.tec.lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import mx.tec.lists.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(R.layout.activity_main)
        setContentView(binding.root)

        /* val lvList = findViewById<ListView>(R.id.lvList)
        val spList = findViewById<Spinner>(R.id.spList) */
        val data = listOf("Item 1", "Item 2", "Item 3", "Item 4")

        val adapter = ArrayAdapter<String>(
            this@MainActivity,

            //get resources from SDK, design from library
            android.R.layout.simple_list_item_1,
            data
        )

        // Access id from binding object (root .xml)
        binding.lvList.adapter = adapter
        binding.spList.adapter = adapter

        // parent = a ListView, view = screen size
        binding.lvList.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                1 -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Touch one item", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}