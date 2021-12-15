package com.breens.adaninalabsandroidtets.ui.fragments

import androidx.lifecycle.*
import com.breens.adaninalabsandroidtets.data.remote.ImagesResponse
import com.breens.adaninalabsandroidtets.repositories.ImageRepository
import com.breens.adaninalabsandroidtets.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val repository: ImageRepository
) : ViewModel() {
    var images = repository.getImages().asLiveData()
    private val searchedImages: MutableLiveData<Resource<ImagesResponse>> = MutableLiveData()
    var searched: MutableLiveData<Resource<ImagesResponse>> = searchedImages


    fun fetchImages(searchQuery: String) = viewModelScope.launch {
        searchedImages.postValue(Resource.Loading())
        val response = repository.searchImages(searchQuery)
        searchedImages.postValue(handleImageResponse(response))
    }


    private fun handleImageResponse(response: Response<ImagesResponse>): Resource<ImagesResponse> {
        if (response.isSuccessful) {
            response.body()?.let { imagesResponse ->
                return Resource.Success(imagesResponse)
            }
        }
        return Resource.Error(response.message())
    }
}