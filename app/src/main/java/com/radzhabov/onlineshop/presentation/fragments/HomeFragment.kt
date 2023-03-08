package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.radzhabov.onlineshop.data.network.service.NetworkService
import com.radzhabov.onlineshop.data.repositories.FlashSaleRepository
import com.radzhabov.onlineshop.data.repositories.LatestRepository
import com.radzhabov.onlineshop.presentation.main.MainActivity
import com.radzhabov.onlineshop.databinding.FragmentHomeBinding
import com.radzhabov.onlineshop.presentation.adapter.FlashSaleAdapter
import com.radzhabov.onlineshop.presentation.adapter.LatestAdapter
import com.radzhabov.onlineshop.presentation.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val flashSaleAdapter = FlashSaleAdapter(emptyList())
    private val latestAdapter = LatestAdapter(emptyList())
    private val viewModel: HomeViewModel by viewModels{
        HomeViewModel.Factory(
            FlashSaleRepository(NetworkService.getInstance().flashSaleApi),
            LatestRepository(NetworkService.getInstance().latestApi)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).navView.visibility = View.VISIBLE
        _binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            flashSaleRecycler.adapter = flashSaleAdapter
            latestRecycler.adapter = latestAdapter
        }

        viewModel.flashSale.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                flashSaleAdapter.updateFlashSaleList(it)
            }
        }

        viewModel.latest.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                latestAdapter.updateLatestList(it)
            }
        }

        return _binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.updateRepository()
    }
}