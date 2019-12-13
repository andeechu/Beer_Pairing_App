package com.example.beer_pairing_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.beer_pairing_app.model.Beer
import com.example.beer_pairing_app.repository.Repository

class MainViewModel : ViewModel() {
    private val _category: MutableLiveData<String> = MutableLiveData()

    val beers : LiveData<Array<Beer>> = Transformations
        .switchMap(_category){ category ->
            Repository.getCategory(category)
        }

    // Appending category
    fun setCategory(category: String){
        val update = category
        if(_category.value == update){
            return
        }
        _category.value = update
    }
}