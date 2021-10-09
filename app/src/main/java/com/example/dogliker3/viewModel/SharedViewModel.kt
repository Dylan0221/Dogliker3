package com.example.dogliker3.viewModel

import android.app.Activity
import android.icu.number.NumberFormatter.with
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.dogliker3.adapters.recyclerView.RecyclerViewAdapter
import com.example.dogliker3.data.api.ApiService
import com.example.dogliker3.databinding.ActivityMainBinding
import com.example.dogliker3.model.DogResponse
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class SharedViewModel: ViewModel() {

   private var currentDog: String = ""



    var likedDogs = mutableListOf<String>()


    private fun api(): ApiService =
            Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breeds/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)


     fun getImage(imagebind:ImageView) {
        GlobalScope.launch(Dispatchers.IO) {
            val data  = api().getDog().body()!!
            val response = data.image
            currentDog = response


            withContext(Dispatchers.Main){

                loadImage(imageUrl = response, imageView = imagebind )


            }


        }

    }


    private fun loadImage(imageView: ImageView,imageUrl: String){
            Picasso.get().load(imageUrl).into(imageView)
    }

    fun addLikedDogs(imageView: ImageView){
        if (currentDog !in likedDogs) {
                likedDogs.add(currentDog)
                imageView.visibility = View.VISIBLE

        }else if (currentDog in likedDogs) {
                likedDogs.remove(currentDog)
                imageView.visibility = View.INVISIBLE
        }

  }


}


