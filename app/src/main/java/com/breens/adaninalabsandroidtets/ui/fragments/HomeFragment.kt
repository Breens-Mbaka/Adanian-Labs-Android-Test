package com.breens.adaninalabsandroidtets.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.breens.adaninalabsandroidtets.R
import com.breens.adaninalabsandroidtets.databinding.FragmentHomeBinding
import com.breens.adaninalabsandroidtets.ui.adapters.ImageAdapter
import com.breens.adaninalabsandroidtets.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageAdapter: ImageAdapter

    private val viewModel: ImagesViewModel by viewModels()

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
        setUpImageRecyclerView()
        setUpImageClickListener()
        setUpUi()
        setHasOptionsMenu(true)
    }

    private fun setUpUi() {
        viewModel.images.observe(viewLifecycleOwner) { result ->
            imageAdapter.differ.submitList(
                result.data)
            binding.apply {
                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textviewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textviewError.text = result.message
            }
        }
    }

    private fun setUpImageRecyclerView() {
        imageAdapter = ImageAdapter()
        binding.imagesRecyclerview.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_bar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id= item.itemId
        if (id == R.id.action_search) {
            findNavController().navigate(
                R.id.action_homeFragment_to_searchFragment
            )
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}