package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.radzhabov.onlineshop.presentation.main.MainActivity
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.databinding.FragmentSignUpBinding
import com.radzhabov.onlineshop.presentation.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val navController by lazy { findNavController() }
    private val viewModel: AuthViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).navView.visibility = View.GONE

        binding = FragmentSignUpBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@SignUpFragment.viewModel
            btnRegister.setOnClickListener { register() }
            login.setOnClickListener{ backToLogin() }
        }

        viewModel.user.observe(viewLifecycleOwner) {}
        return binding.root
    }

    private fun register() {
        viewModel.register()
        navController.navigate(R.id.action_navigation_sing_up_to_navigation_sing_in2)
    }

    private fun backToLogin() {
        navController.navigate(R.id.action_navigation_sing_up_to_navigation_sing_in2)
    }
}