package com.breens.adaninalabsandroidtets.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.breens.adaninalabsandroidtets.R
import com.breens.adaninalabsandroidtets.databinding.FragmentSearchBinding
import com.breens.adaninalabsandroidtets.ui.adapters.ImageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.fragment_search) {


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageAdapter: ImageAdapter

    private val viewModel: ImagesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
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
        viewModel.searched.observe(viewLifecycleOwner) { result ->
            imageAdapter.differ.submitList(result.hits)
        }
    }

    private fun setUpImageRecyclerView() {
        imageAdapter = ImageAdapter()
        binding.searchRecyclerview.apply {
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
                R.id.action_searchFragment_to_detailsFragment,
                bundle
            )
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_bar_menu_search, menu)

        val searchItem = menu.findItem(R.id.action_search)
        searchItem.expandActionView()
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    binding.searchRecyclerview.scrollToPosition(0)
                    viewModel.fetchImages(query)
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}