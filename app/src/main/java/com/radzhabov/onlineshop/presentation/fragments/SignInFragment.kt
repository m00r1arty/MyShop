package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.data.db.AppDatabase
import com.radzhabov.onlineshop.databinding.FragmentSignInBinding
import com.radzhabov.onlineshop.domain.common.MAIN
import com.radzhabov.onlineshop.presentation.viewmodels.AuthViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInFragment : Fragment() {
    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        val authViewModelFactory = AuthViewModel.Factory(AppDatabase.getInstance(requireContext()).userDao())
        viewModel = ViewModelProvider(this, authViewModelFactory)[AuthViewModel::class.java]

        binding.btnLogin.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                if (viewModel.login(firstName)){
                    withContext(Dispatchers.Main){
                        MAIN.navController.navigate(R.id.action_navigation_sing_in_to_navigation_home)

                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()
                        MAIN.navController.navigate(R.id.action_navigation_sing_in_to_navigation_sing_up2)
                    }
                }
            }
        }
        return binding.root
    }
}