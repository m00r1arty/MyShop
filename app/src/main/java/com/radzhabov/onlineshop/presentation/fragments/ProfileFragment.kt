package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner

            logout.setOnClickListener { navigateToSignIn() }
        }

        return binding.root
    }

    private  fun navigateToSignIn() = navController.navigate(R.id.action_navigation_profile_to_navigation_sing_in)

}