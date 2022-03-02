package com.example.myapp.service

import com.example.myapp.service.dto.Brewery
import retrofit2.Call
import retrofit2.http.GET


interface BreweryService {
    @GET("breweries/fargo-brewing-co-fargo")
    fun getBrewery() : Call<Brewery>
}
