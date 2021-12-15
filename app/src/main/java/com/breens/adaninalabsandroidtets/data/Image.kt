package com.breens.adaninalabsandroidtets.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "images"
)
data class Image(
    @PrimaryKey
    val id : Int,
    val type : String,
    val tags : String,
    val webformatURL : String,
    val views: Int,
    val downloads : Int,
    val likes : Int,
    val comments : Int,
    val user: String
): Serializable
