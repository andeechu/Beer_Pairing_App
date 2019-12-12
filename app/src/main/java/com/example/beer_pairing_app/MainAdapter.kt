package com.example.beer_pairing_app

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beer_pairing_app.model.Beer
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

        val beer = beers[position]


        if(position % 2 == 0){
            holder.view.beer_card.setBackgroundColor(Color.rgb(250,217,237))
        }

        val name = beer.name
        holder.view.textView_beer_title.text = name

        val tagline = beer.tagline
        holder.view.textView_beer_tagline.text = tagline

        val description = beer.description
        holder.view.textView_beer_description.text = "Taste: $description"

        val abv = beer.abv
        holder.view.textView_beer_abv.text = "Alcohol by volume: $abv"

        // Suggested foods are stored in an array, so we have to parse array to a single string
        val foods = beer.food_pairing

        // joinToString parses array into a single string using a custom separator
        val allFoods = foods.joinToString(", ")

        // updating text for food pairing text view
        val suggestedFoods = "Eat with:  $allFoods"
        holder.view.textView_beer_food_pairing.text = suggestedFoods
    }

}

// CustomViewHolder class on the fly
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}