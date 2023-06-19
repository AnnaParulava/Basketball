package com.example.basketball.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketball.R
import com.example.basketball.databinding.FragmentHomeBinding
import com.example.basketball.ui.adapter.MatchRecyclerAdapter
import com.example.basketball.viewmodel.MatchViewModel

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    private val binding
        get() = _binding
            ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")

    private val viewModel by lazy {
        ViewModelProvider(this)[MatchViewModel::class.java]
    }


    private val matchAdapter by lazy {
        MatchRecyclerAdapter()
    }

    private fun initRecyclerView() {
        binding.matchesRecyclerView.apply {
            adapter = matchAdapter
            layoutManager = LinearLayoutManager(requireContext())

            matchAdapter.onCoinClickListener = object : MatchRecyclerAdapter.OnCoinClickListener {
                override fun onCoinClick() {

                    findNavController().navigate(R.id.webViewFragment)
                }
            }
        }
    }

    private fun observeMatches() {
        viewModel.matches.observe(viewLifecycleOwner, Observer { matches ->
            matchAdapter.submitList(matches)
            matchAdapter.matchList = matches
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        observeMatches()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}