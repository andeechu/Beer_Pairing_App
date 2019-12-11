package com.example.beer_pairing_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beer_pairing_app.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // The following lines have been commented out due to recycler view testing
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this, navController)

        setContentView(R.layout.activity_main)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        fetchJson()
    }

//    // The following function was commented out due to recycler view testing
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        return navController.navigateUp()
//    }

    private fun fetchJson() {

        println("Attempting to fetch JSON")

        // URL for beers api (Returns 25 beers)
        //val url = "https://api.punkapi.com/v2/beers"
        val url = "https://api.punkapi.com/v2/beers?food=spicy"

        // Creating okHttpClient for fetching from API
        val client = OkHttpClient()

        // Creating a request
        val request = Request.Builder().url(url).build()

        // Can't run execute on main thread so enqueue is used instead
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                println("successful fetch")

                // printing body object for testing purposes
                //println(body)

                val gson = GsonBuilder().create()

                // Link demonstrates how to create list from JSON object
                // https://stackoverflow.com/questions/53685627/expected-begin-object-but-was-begin-array-kotlin
                val beers: List<Beer> = gson.fromJson(body, Array<Beer>::class.java).toList()
                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(beers)
                }

//                // Iterating through gson created object to check results
//                beers.forEach{
//                    println(it.id)
//                    println("Beer name: " + it.name)
//                    println("Tagline: " + it.tagline)
//                    println("description: " + it.description)
//                }

            }
            override fun onFailure(call: Call, e: IOException) {
                println("failed to execute")
            }
        })

    }

}

class Beer(val id: Int, val name: String, val tagline: String, val description: String, val abv: String, val food_pairing: Array<String>)
