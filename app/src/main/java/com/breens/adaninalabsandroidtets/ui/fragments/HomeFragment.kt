package com.breens.adaninalabsandroidtets.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.breens.adaninalabsandroidtets.R
import com.breens.adaninalabsandroidtets.databinding.FragmentHomeBinding
import com.breens.adaninalabsandroidtets.ui.adapters.ImageAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageAdapter: ImageAdapter

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
        setUpImageClickListener()
        setUpImageRecyclerView()
    }

    private fun setUpImageRecyclerView() {
        imageAdapter = ImageAdapter()
        binding.imagesRecyclerview.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setUpImageClickListener() {
        imageAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("imageDetails", it)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_detailsFragment,
                bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}