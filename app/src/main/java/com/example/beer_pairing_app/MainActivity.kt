package com.example.beer_pairing_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beer_pairing_app.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // The following lines have been commented out due to recycler view testing
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this, navController)


        recyclerView_main.layoutManager = LinearLayoutManager(this)
        val topSpacingDecoration = TopSpacingItemDecoration(30)
        recyclerView_main.addItemDecoration(topSpacingDecoration)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.beers.observe(this, Observer{
            println(it.toList())
            recyclerView_main.adapter = MainAdapter(it.toList())
        })

        viewModel.setCategory("sweet")

    }


//    // The following function was commented out due to recycler view testing
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        return navController.navigateUp()
//    }

}
