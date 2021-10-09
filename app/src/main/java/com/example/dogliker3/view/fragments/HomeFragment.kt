package com.example.dogliker3.view.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dogliker3.R
import com.example.dogliker3.databinding.FragmentHomeBinding
import com.example.dogliker3.viewModel.SharedViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentHomeBinding.inflate(inflater, container, false)





        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        changeImage()




        binding.toLikedbutton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_likedDogsFragment)
        }

        binding.likeButton.setOnClickListener {
            sharedViewModel.addLikedDogs(binding.likedPicture)
        }

        binding.changeButton.setOnClickListener{
            changeImage()
        }

    }

    private fun changeImage(){
        sharedViewModel.getImage(binding.cardImageView)
        binding.likedPicture.visibility = View.INVISIBLE

    }




}