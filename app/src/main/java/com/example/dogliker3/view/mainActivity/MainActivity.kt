package com.example.dogliker3.view.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.dogliker3.R
import com.example.dogliker3.databinding.ActivityMainBinding
import com.example.dogliker3.view.fragments.HomeFragment
import com.example.dogliker3.viewModel.SharedViewModel

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val viewModel = ViewModelProvider(this)[SharedViewModel::class.java]









        Log.v("MyActivity","funciona la vaina")
        setContentView(binding.root)

    }


}