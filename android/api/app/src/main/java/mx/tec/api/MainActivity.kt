package mx.tec.api

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import mx.tec.api.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    // Temporal buffer for the data received from the server, global variable and lateinit means that's not null
    lateinit var queue: RequestQueue
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(R.layout.activity_main)
        setContentView(binding.root)
        queue = Volley.newRequestQueue(this)

        val url = "https://jsonplaceholder.typicode.com/users"
        val listener = Response.Listener<JSONArray> { response ->
            // Log.e("API RESPONSE", response.toString())

            // Modificable list
            var data = mutableListOf<String>()
            for (i in 0 until response.length()) {
                data.add(response.getJSONObject(i).getString("id") + "\n"
                        + response.getJSONObject(i).getString("name") + "\n"
                        + response.getJSONObject(i).getString("email") + "\n"
                        // access address.street
                        + response.getJSONObject(i).getJSONObject("address").getString("street"))
                /* val user = response.getJSONObject(i)
                val name = user.getString("name")
                val email = user.getString("email")
                val phone = user.getString("phone")
                val company = user.getJSONObject("company")
                val companyName = company.getString("name")
                val companyCatchPhrase = company.getString("catchPhrase")
                val companyBs = company.getString("bs")
                Log.e("API RESPONSE", "$name - $email - $phone - $companyName - $companyCatchPhrase - $companyBs") */
            }
            val adapter = ArrayAdapter(this@MainActivity, R.layout.simple_list_item_1, data)
            binding.llList.adapter = adapter
        }
        val errorListener = Response.ErrorListener { error ->
            // Handle the error with not null error if an error occurred
            Log.e("API ERROR", error.message!!)
        }

        // Just in case
        val body = JSONObject()
        body.put("name", "John Doe")
        body.put("email", "johndoe@email.com")
        body.put("phone", "1234567890")
        body.put("password", "123456")

        val request = JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener)
        queue.add(request)

        /* val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { textView.text = "That didn't work!" }) */
    }
}