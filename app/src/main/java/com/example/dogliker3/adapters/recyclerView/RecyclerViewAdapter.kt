package com.example.dogliker3.adapters.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogliker3.R
import com.example.dogliker3.model.DogResponse

class RecyclerViewAdapter(var dogs: List<String>) : RecyclerView.Adapter<DogItemViewHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item_recyclerview, parent,false)
        return DogItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogItemViewHolder, position: Int) {
        val item: String = dogs[position]
        holder.bind(item)


    }

    override fun getItemCount(): Int = dogs.size
}