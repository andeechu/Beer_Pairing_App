package com.example.beer_pairing_app.api

import com.example.beer_pairing_app.model.Beer
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Request will return an Array of beer objects
    @GET("beers/")
    // passing in parameter to the URL string
    suspend fun getBeers(
        @Query("food") category: String
    ): Array<Beer>
}