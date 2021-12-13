package com.breens.adaninalabsandroidtets.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.breens.adaninalabsandroidtets.R
import com.breens.adaninalabsandroidtets.databinding.FragmentDetailsBinding

class DetailsFragment:Fragment(R.layout.fragment_details) {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
    }

    private fun setUpUi() {
        val details = args.imageDetails
        val imageUrl = details.previewUrl
        val user = details.user
        val viewNumber = details.views.toString()
        val downloadNumber = details.downloads.toString()
        val commentNumber = details.comments.toString()

        binding.apply {
            imageView.load(imageUrl){
                crossfade(true)
            }
            userName.text = user
            views.text = viewNumber
            downloads.text = downloadNumber
            comments.text = commentNumber
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}