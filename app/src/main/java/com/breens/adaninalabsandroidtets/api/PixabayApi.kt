package com.breens.adaninalabsandroidtets.api

import com.breens.adaninalabsandroidtets.data.ImagesResponse
import com.breens.adaninalabsandroidtets.util.Constants.Companion.API_KEY
import com.breens.adaninalabsandroidtets.util.Constants.Companion.DOGS_SEARCH_QUERY
import com.breens.adaninalabsandroidtets.util.Constants.Companion.ENDPOINT
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET(ENDPOINT)
    suspend fun fetchImages(
        @Query("key") apiKey: String = API_KEY,
        @Query("q") searchQuery: String = DOGS_SEARCH_QUERY
    ): ImagesResponse
}