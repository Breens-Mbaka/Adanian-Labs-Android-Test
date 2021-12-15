package com.breens.adaninalabsandroidtets.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.breens.adaninalabsandroidtets.data.Image

@Database(
    entities = [Image::class],
    version = 1
)
abstract class ImagesDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
}