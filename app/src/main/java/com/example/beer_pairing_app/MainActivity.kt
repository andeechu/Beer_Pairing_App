package com.example.beer_pairing_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.beer_pairing_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val spicyButton = findViewById<Button>(R.id.spicy)
        spicyButton.setOnClickListener{
            val intent: Intent = Intent(applicationContext, BeersList::class.java)
            intent.putExtra("category", "spicy")
            startActivity(intent)
        }

        val sweetButton = findViewById<Button>(R.id.sweet)
        sweetButton.setOnClickListener{
            val intent: Intent = Intent(applicationContext, BeersList::class.java)
            intent.putExtra("category", "sweet")
            startActivity(intent)
        }

        val sourButton = findViewById<Button>(R.id.sour)
        sourButton.setOnClickListener{
            val intent: Intent = Intent(applicationContext, BeersList::class.java)
            intent.putExtra("category", "sour")
            startActivity(intent)
        }

        val bitterButton = findViewById<Button>(R.id.bitter)
        bitterButton.setOnClickListener{
            val intent: Intent = Intent(applicationContext, BeersList::class.java)
            intent.putExtra("category", "bitter")
            startActivity(intent)
        }


    }

}
