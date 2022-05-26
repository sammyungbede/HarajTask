package com.example.harajtask

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.harajtask.databinding.FragmentPostInformationBinding
import java.util.*


class PostInformationFragment : Fragment(R.layout.fragment_post_information) {
    private lateinit var binding: FragmentPostInformationBinding
    val safeArgs : PostInformationFragmentArgs by navArgs()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostInformationBinding.bind(view)
        val itemName = safeArgs.postInformation.title
        val date = safeArgs.postInformation.date
        val userName = safeArgs.postInformation.username
        val city = safeArgs.postInformation.city
      //  val imageUrl = safeArgs.postInformation.thumbURL
        Glide.with(this).load(safeArgs.postInformation.thumbURL)
            .into(binding.mainImageImageView)
        binding.ItemNameForSaletextView.text = itemName
        binding.itemNameTextTextView.text = itemName
        binding.dateTextTextView.text = date.toString()
        binding.userNametextView.text = userName
        binding.locationTextView.text = city
        binding.itemForSaleLocationtextView.text = city


    }






}