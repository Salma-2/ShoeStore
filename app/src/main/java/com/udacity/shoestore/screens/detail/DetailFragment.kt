package com.udacity.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.screens.SharedShoeViewModel


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    private val viewModel: SharedShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.detailViewModel = viewModel


        viewModel.eventSave.observe(viewLifecycleOwner) { isSaved ->
            if (isSaved) {
                navigateToListScreen()
                viewModel.onSaveComplete()
            }
        }

        viewModel.eventCancel.observe(viewLifecycleOwner) { isCanceled ->
            if (isCanceled) {
                navigateToListScreen()
                viewModel.onCancelComplete()
            }

        }
        return binding.root
    }


    private fun navigateToListScreen() {
        this.findNavController().navigate(R.id.action_detailFragment_to_shoeListFragment)
    }

}