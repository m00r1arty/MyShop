package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.radzhabov.data.repositories.UserRepository
import com.radzhabov.onlineshop.presentation.main.MainActivity
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.databinding.FragmentSignInBinding
import com.radzhabov.onlineshop.presentation.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val navController by lazy { findNavController() }
    private val viewModel: AuthViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as MainActivity).navView.visibility = View.GONE

        binding = FragmentSignInBinding.inflate(inflater, container, false).apply {
            viewModel = this@SignInFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            btnLogin.setOnClickListener { signIn() }
        }

        viewModel.user.observe(viewLifecycleOwner) {}
        return binding.root
    }

    private fun signIn() {
        viewModel.login().observe(viewLifecycleOwner) { isSigned ->
            isSigned?.let { navigateIfSigned(it) }
        }
    }

    private fun navigateIfSigned(isSigned: Boolean) {
        if (isSigned) {
            navController.navigate(R.id.action_navigation_sing_in_to_navigation_home)
        } else {
            Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()
        }
    }
}