package com.breens.adaninalabsandroidtets.api

import com.breens.adaninalabsandroidtets.data.remote.ImagesResponse
import com.breens.adaninalabsandroidtets.util.Constants.Companion.API_KEY
import com.breens.adaninalabsandroidtets.util.Constants.Companion.DOGS_SEARCH_QUERY
import com.breens.adaninalabsandroidtets.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    //Display initial search to dog images
    @GET(ENDPOINT)
    suspend fun fetchImages(
        @Query("key") apiKey: String = API_KEY,
        @Query("q") searchQuery: String = DOGS_SEARCH_QUERY
    ): ImagesResponse


    //custom user search
    @GET(ENDPOINT)
    suspend fun searchImages(
        @Query("key") apiKey: String = API_KEY,
        @Query("q") searchQuery: String
    ): Response<ImagesResponse>
}