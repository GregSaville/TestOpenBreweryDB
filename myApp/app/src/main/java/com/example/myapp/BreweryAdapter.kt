package com.example.myapp;


import com.example.myapp.service.dto.Brewery;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BreweryAdapter(val data: ArrayList<String>) : RecyclerView.Adapter<BreweryAdapter.BreweryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_brewery_textview, parent, false)

        return BreweryViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class BreweryViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView :TextView

        init{
            textView = view.findViewById(R.id.tv_data)
        }
    }

}
