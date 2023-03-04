package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.radzhabov.onlineshop.databinding.FragmentBasketBinding
import com.radzhabov.onlineshop.presentation.viewmodels.BasketViewModel

class BasketFragment : Fragment() {

    private var _binding: FragmentBasketBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val basketViewModel =
            ViewModelProvider(this).get(BasketViewModel::class.java)

        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBasked
        basketViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}