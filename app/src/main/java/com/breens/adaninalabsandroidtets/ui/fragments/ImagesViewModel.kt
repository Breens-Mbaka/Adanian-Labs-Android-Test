package com.breens.adaninalabsandroidtets.ui.fragments

import androidx.lifecycle.*
import com.breens.adaninalabsandroidtets.api.PixabayApi
import com.breens.adaninalabsandroidtets.data.ImagesResponse
import com.breens.adaninalabsandroidtets.repository.ImageRepository
import com.breens.adaninalabsandroidtets.util.Constants.Companion.API_KEY
import com.breens.adaninalabsandroidtets.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val repository: ImageRepository
) : ViewModel() {
    var images = repository.getImages().asLiveData()
    private val searchedImages: MutableLiveData<ImagesResponse> = MutableLiveData()
    var searched: MutableLiveData<ImagesResponse> = searchedImages


    fun fetchImages(searchQuery: String) = viewModelScope.launch {
        val response = repository.searchImages(searchQuery)
        searchedImages.postValue(response)
    }

}