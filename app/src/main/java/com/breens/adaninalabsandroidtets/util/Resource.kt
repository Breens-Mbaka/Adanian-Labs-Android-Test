package com.breens.adaninalabsandroidtets.util

sealed class Resource<T>{
    class Success<T>(data: T) : Resource<T>()
    class Loading<T>(data: T? = null) : Resource<T>()
    class Error<T>(throwable: Throwable, data: T? = null) : Resource<T>()

}