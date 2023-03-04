package com.radzhabov.onlineshop.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.radzhabov.onlineshop.databinding.FragmentCommentsBinding
import com.radzhabov.onlineshop.presentation.viewmodels.CommentsViewModel

class CommentsFragment : Fragment() {
    private var _binding: FragmentCommentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val commentsViewModel =
            ViewModelProvider(this).get(CommentsViewModel::class.java)

        _binding = FragmentCommentsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textComments
        commentsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}