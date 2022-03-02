package com.example.myapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.service.BreweryService
import com.example.myapp.service.dto.Brewery
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.myapp.BreweryAdapter as BreweryAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var rvItems : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factService = buildService()
        val breweries = ArrayList<String>()

        factService.getBrewery().enqueue(object : Callback<Brewery> {
            override fun onResponse(call: Call<Brewery>, response: Response<Brewery>) {
                breweries.add(response.body()?.name.toString())
                Log.i("asdf", breweries.get(0).toString())

            }

            override fun onFailure(call: Call<Brewery>, t: Throwable) {
                Log.e("asdf","onFailure")
            }

        })
        rvItems = findViewById(R.id.rv_breweries)
        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = BreweryAdapter(breweries)
    }

    private fun buildService(): BreweryService{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openbrewerydb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(BreweryService::class.java)
    }

}