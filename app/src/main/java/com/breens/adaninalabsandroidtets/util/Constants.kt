package com.breens.adaninalabsandroidtets.util

import com.breens.adaninalabsandroidtets.BuildConfig

class Constants {
    companion object {
        const val BASE_URL = "https://pixabay.com/api/"
        const val API_KEY = BuildConfig.API_KEY
        const val ENDPOINT = "/api"
        const val DOGS_SEARCH_QUERY = "dogs"
    }
}