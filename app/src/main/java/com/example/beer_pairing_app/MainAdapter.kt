package com.example.beer_pairing_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.beer_row.view.*

class MainAdapter(val beers: List<Beer>): RecyclerView.Adapter<CustomViewHolder>() {

    // Getting the number of beers per request
    override fun getItemCount(): Int {
        return beers.size
    }

    // Inflating layout to include a beer picture and description
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.beer_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    // Changing contents of xml file based on request results
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val beer = beers.get(position)
        holder.view.textView_beer_title.text = beer.name
    }

}

// CustomViewHolder class on the fly
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}