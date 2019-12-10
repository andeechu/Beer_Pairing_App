package com.example.beer_pairing_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.beer_pairing_app.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        fetchJson()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

    fun fetchJson() {

        println("Attempting to fetch JSON")

        // URL for beers api
        // val url = "https://api.punkapi.com/v2/beers"

        // URL for online example
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        // Creating okHttpClient for fetching from API
        val client = OkHttpClient()

        // Creating a request
        val request = Request.Builder().url(url).build()

        // Can't run execute on main thread so enqueue is used instead
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                print("successful fetch")

                // printing body object for testing purposes
                println(body)

                val gson = GsonBuilder().create()
                // val beers = gson.fromJson(body, Bar::class.java)
                val homefeed = gson.fromJson(body, HomeFeed::class.java)


            }
            override fun onFailure(call: Call, e: IOException) {
                println("failed to execute")
            }
        })

    }

}

class Bar(val beers: List<Beer>)

class Beer(val id: Int, val name: String)

// Classes from online example

class HomeFeed(val videos: List<MediaStore.Video>)

class Video(val id: Int, val name: String)
