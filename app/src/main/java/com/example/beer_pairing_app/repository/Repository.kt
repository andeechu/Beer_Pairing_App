package com.example.beer_pairing_app.repository

import androidx.lifecycle.LiveData
import com.example.beer_pairing_app.api.MyRetrofitBuilder
import com.example.beer_pairing_app.model.Beer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object Repository {

    fun getCategory(category: String): LiveData<Array<Beer>>{
        return object: LiveData<Array<Beer>>(){
            override fun onActive(){
                super.onActive()
                CoroutineScope(IO).launch {
                    val beer = MyRetrofitBuilder.apiService.getBeers(category)
                    withContext(Main){
                        value = beer
                    }
                }
            }
        }
    }

}