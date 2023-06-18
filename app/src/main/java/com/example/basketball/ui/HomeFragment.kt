package com.example.basketball.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketball.api.ApiFactory.apiService
import com.example.basketball.databinding.FragmentHomeBinding
import com.example.basketball.ui.adapter.MatchRecyclerAdapter
import com.example.basketball.viewmodel.MatchViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding
        ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")

    private val viewModel by lazy {
        ViewModelProvider(this)[MatchViewModel::class.java]
    }

    private lateinit var matchAdapter: MatchRecyclerAdapter

//    private val matchAdapter by lazy {
//        MatchRecyclerAdapter()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchAdapter = MatchRecyclerAdapter()
//        lifecycleScope.launch {
//
//            val responseCategory = apiService.getCountries()
//            Log.d("AAA", "Category: ${responseCategory}")
//        }

        initRecyclerView()
        observeMatches()
    }

    private fun initRecyclerView() {
        binding.matchesRecyclerView.apply {
            adapter = matchAdapter
            ///layoutmanager можно убрать
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeMatches() {
        viewModel.matches.observe(viewLifecycleOwner, Observer { matches ->
            matchAdapter.submitList(matches)
            matchAdapter.matchList = matches
            Log.d("AAA", "HomeFragment Matches $matches")
        })
    }


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