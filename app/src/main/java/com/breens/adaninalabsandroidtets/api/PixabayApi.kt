package com.breens.adaninalabsandroidtets.api

import com.breens.adaninalabsandroidtets.data.ImagesResponse
import com.breens.adaninalabsandroidtets.util.Constants.Companion.ENDPOINT
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @FormUrlEncoded
    @GET(ENDPOINT)
    suspend fun fetchImages(
        @Query("q") searchQuery: String
    ):ImagesResponse
}