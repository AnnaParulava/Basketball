package com.example.basketball.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.basketball.R
import com.example.basketball.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {


    private var _binding: FragmentWebViewBinding? = null

    private val binding get() = _binding
        ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        binding.webView.settings.apply {
            javaScriptEnabled = true
        }
        binding.webView.loadUrl("https://dashboard.onesignal.com/apps/23d5e553-659d-45da-a3d5-d4130125639a")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupWebView()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}