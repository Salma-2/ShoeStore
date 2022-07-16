package com.udacity.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
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