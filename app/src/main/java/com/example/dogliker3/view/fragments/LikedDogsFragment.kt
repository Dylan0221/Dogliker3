package com.example.dogliker3.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogliker3.R
import com.example.dogliker3.adapters.recyclerView.RecyclerViewAdapter
import com.example.dogliker3.databinding.FragmentHomeBinding
import com.example.dogliker3.databinding.FragmentLikedDogsBinding
import com.example.dogliker3.view.mainActivity.MainActivity
import com.example.dogliker3.viewModel.SharedViewModel

class LikedDogsFragment : Fragment() {

    private var _binding: FragmentLikedDogsBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLikedDogsBinding.inflate(inflater, container, false)








        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        binding.toHomeButton.setOnClickListener{
            findNavController().navigate(R.id.action_likedDogsFragment_to_homeFragment)
        }

    }

    private fun initRecyclerView(){
        binding.recyclerViewLikedDogs.apply {
            layoutManager = LinearLayoutManager(context)
            binding.recyclerViewLikedDogs.adapter = RecyclerViewAdapter(sharedViewModel.likedDogs)

        }

    }



}