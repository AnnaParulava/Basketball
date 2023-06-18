package com.example.basketball.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.basketball.api.ApiFactory.apiService
import com.example.basketball.databinding.FragmentHomeBinding
import com.example.basketball.ui.adapter.MatchRecyclerAdapter
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {

            val responseCategory = apiService.getCountries()
            Log.d("AAA", "Category: ${responseCategory}")
        }

        val adapter = MatchRecyclerAdapter()
        binding.matchesRecyclerView.adapter = adapter
        //// viewmodel
    }


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
        ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}