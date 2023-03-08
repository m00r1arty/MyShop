package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.radzhabov.onlineshop.presentation.main.MainActivity
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.databinding.FragmentSignInBinding
import com.radzhabov.onlineshop.presentation.viewmodels.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel: AuthViewModel by viewModels ()
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        (activity as MainActivity).navView.visibility = View.GONE

        binding.btnLogin.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                if (viewModel.login(firstName)){
                    withContext(Dispatchers.Main){
                        navController.navigate(R.id.action_navigation_sing_in_to_navigation_home)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()
                        navController.navigate(R.id.action_navigation_sing_in_to_navigation_sing_up2)
                    }
                }
            }
        }
        return binding.root
    }
}