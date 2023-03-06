package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.radzhabov.onlineshop.databinding.FragmentBasketBinding
import com.radzhabov.onlineshop.databinding.FragmentSignInBinding
import com.radzhabov.onlineshop.databinding.FragmentSignUpBinding

class BasketFragment : Fragment() {

    private lateinit var binding: FragmentBasketBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }
}