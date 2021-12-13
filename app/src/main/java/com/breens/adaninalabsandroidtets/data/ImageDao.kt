package com.breens.adaninalabsandroidtets.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {

    /**
     *The response from our API will be cached in the user's mobile.
     * Then our ui will be reading and observing changes from the db
     * making our app offline
    **/
    @Query("SELECT * FROM images")
    fun getAllImages(): Flow<List<Image>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(images: List<Image>)

    @Query("DELETE FROM images")
    suspend fun deleteAllImages()
}