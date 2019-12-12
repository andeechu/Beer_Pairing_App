package com.example.beer_pairing_app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Beer class for JSON objects from request
data class Beer(
    @Expose
    @SerializedName("name")
    val name: String? = null,

    @Expose
    @SerializedName("tagline")
    val tagline: String? = null,

    @Expose
    @SerializedName("description")
    val description: String? = null,

    @Expose
    @SerializedName("abv")
    val abv: String? = null,

    @Expose
    @SerializedName("food_pairing")
    val food_pairing: Array<String>


) {
    override fun toString(): String {
        return "Beer(name=$name, tagline=$tagline, description=$description, avb=$abv, food_pairing,$food_pairing)"
    }

    // The following functions were implemented to remove warnings due to Array<String>
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        return true
    }

    override fun hashCode(): Int{
       return 1
    }
}