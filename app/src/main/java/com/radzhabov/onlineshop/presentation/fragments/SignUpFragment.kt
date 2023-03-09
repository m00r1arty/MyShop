package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.radzhabov.onlineshop.presentation.main.MainActivity
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.databinding.FragmentSignUpBinding
import com.radzhabov.onlineshop.presentation.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        (activity as MainActivity).navView.visibility = View.GONE

        binding.btnRegister.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                // Registred new user
                viewModel.register(firstName, lastName, email)
                withContext(Dispatchers.Main) {
                    navController.navigate(R.id.action_navigation_sing_up_to_navigation_sing_in2)
                }
            }
        }

        binding.login.setOnClickListener{
            navController.navigate(R.id.action_navigation_sing_up_to_navigation_sing_in2)
        }

        return binding.root
    }

}