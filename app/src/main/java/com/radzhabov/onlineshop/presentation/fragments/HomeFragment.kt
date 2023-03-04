package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.radzhabov.onlineshop.data.model.FlashSale
import com.radzhabov.onlineshop.data.network.NetworkService
import com.radzhabov.onlineshop.data.repositories.FlashSaleRepository
import com.radzhabov.onlineshop.databinding.FragmentHomeBinding
import com.radzhabov.onlineshop.presentation.adapter.FlashSaleAdapter
import com.radzhabov.onlineshop.presentation.viewmodels.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val adapter = FlashSaleAdapter(emptyList())
    private val viewModel: HomeViewModel by viewModels {
        HomeViewModel.Factory(FlashSaleRepository(NetworkService.getInstance().flashSaleApi))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            flashSaleRecycler.adapter = adapter
        }

        viewModel.flashSale.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapter.updateList(it)
            }
        }
        return _binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.updateFlashSale()
    }
}