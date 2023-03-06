package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.data.db.AppDatabase
import com.radzhabov.onlineshop.databinding.FragmentSignUpBinding
import com.radzhabov.onlineshop.domain.common.MAIN
import com.radzhabov.onlineshop.presentation.viewmodels.AuthViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpFragment : Fragment() {
    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val authViewModelFactory = AuthViewModel.Factory(AppDatabase.getInstance(requireContext()).userDao())
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, authViewModelFactory)[AuthViewModel::class.java]


        binding.btnRegister.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                // Registred new user
                viewModel.register(firstName, lastName, email)
                withContext(Dispatchers.Main) {
                    MAIN.navController.navigate(R.id.action_navigation_sing_up_to_navigation_sing_in2)
                }
            }
        }

        binding.login.setOnClickListener{
            MAIN.navController.navigate(R.id.action_navigation_sing_up_to_navigation_sing_in2)
        }

        return binding.root
    }

}