package mx.tec.localstorage

import android.R
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import mx.tec.localstorage.databinding.ActivityMainBinding
import mx.tec.localstorage.model.Person
import mx.tec.localstorage.utility.AppDatabase
import java.sql.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*multiple files*/
        val sharedPreference = getSharedPreferences("myPreferences", Context.MODE_PRIVATE)

        /*single activity*/
        /*val preference = getPreferences(Context.MODE_PRIVATE)*/

        with(sharedPreference.edit()) {
            putString("user", "userTest")
            putString("password", "1234$.")
            commit()
        }

        val db = AppDatabase.getInstance(this)

        Thread {
            val person = Person(0, "Elviss", "Dominguez", 35, Date.valueOf("2002-03-27"))
            db.personDao().insertPerson(person)
            val people = db.personDao().getPeople()

            val adapter = ArrayAdapter<Person>(
                this@MainActivity,

                //get resources from SDK, design from library
                R.layout.simple_list_item_1,
                people
            )

            binding.lvList.adapter = adapter
        }.start()

        /*for (person in people) {
            println(person.nombre)
        }*/

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