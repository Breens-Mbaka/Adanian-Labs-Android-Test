package com.breens.adaninalabsandroidtets.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.breens.adaninalabsandroidtets.api.PixabayApi
import com.breens.adaninalabsandroidtets.data.ImagesResponse
import com.breens.adaninalabsandroidtets.util.Constants.Companion.API_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val api: PixabayApi
) : ViewModel() {

    private val imagesLiveData = MutableLiveData<ImagesResponse>()
    val images: LiveData<ImagesResponse> = imagesLiveData

    init {
        viewModelScope.launch {
            val images = api.fetchImages()
            imagesLiveData.value = images
        }
    }

    fun fetchImages(searchQuery: String) {
        viewModelScope.launch {
            val images = api.fetchImages(API_KEY, searchQuery)
            imagesLiveData.value = images
        }
    }

}