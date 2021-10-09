package com.example.dogliker3.adapters.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dogliker3.databinding.DogItemRecyclerviewBinding
import com.squareup.picasso.Picasso

class DogItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DogItemRecyclerviewBinding.bind(view)

    fun bind(image: String){
        Picasso.get().load(image).into(binding.dogImageView)
    }
}