package com.breens.adaninalabsandroidtets.data

import java.io.Serializable

data class Image(
    val id : Int,
    val type : String,
    val tags : String,
    val previewUrl : String,
    val views: Int,
    val downloads : Int,
    val likes : Int,
    val comments : Int,
    val user: String
): Serializable
