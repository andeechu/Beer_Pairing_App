package com.example.beer_pairing_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beer_pairing_app.databinding.ActivityBeerlistBinding
import com.example.beer_pairing_app.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_beerlist.*

class BeersList : AppCompatActivity() {

    private lateinit var binding: ActivityBeerlistBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beerlist)
        val passedCategory: String = intent.getStringExtra("category")
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        val topSpacingDecoration = TopSpacingItemDecoration(30)
        recyclerView_main.addItemDecoration(topSpacingDecoration)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.beers.observe(this, Observer{
            println(it.toList())
            recyclerView_main.adapter = MainAdapter(it.toList())
        })

        viewModel.setCategory(passedCategory)
    }
}
