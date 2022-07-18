package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.SharedShoeViewModel
import timber.log.Timber


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding

    private val viewModel: SharedShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.shoeListViewModel = viewModel

        viewModel.eventAddNewShoe.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                this.findNavController().navigate(R.id.action_shoeListFragment_to_detailFragment)
                viewModel.onAddNewShoeComplete()
            }

            viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
                displayShoeList(shoeList)
            }

            setHasOptionsMenu(true)

        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_logout, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    private fun displayShoeList(shoeList: MutableList<Shoe>) {

        shoeList.forEach { shoe ->
            val b = ItemBinding.inflate(layoutInflater, null, false)
            b.shoe = shoe
            binding.container.addView(b.shoeItem)
        }

    }


}