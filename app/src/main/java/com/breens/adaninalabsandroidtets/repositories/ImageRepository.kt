package com.breens.adaninalabsandroidtets.repositories

import androidx.room.withTransaction
import com.breens.adaninalabsandroidtets.api.PixabayApi
import com.breens.adaninalabsandroidtets.data.local.ImagesDatabase
import com.breens.adaninalabsandroidtets.data.remote.ImagesResponse
import com.breens.adaninalabsandroidtets.util.Constants.Companion.API_KEY
import com.breens.adaninalabsandroidtets.util.networkBoundResource
import retrofit2.Response
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val api: PixabayApi,
    private val imageDb: ImagesDatabase
) {
    private val imageDao = imageDb.imageDao()

    fun getImages() = networkBoundResource(
        query = {
            imageDao.getAllImages()
        },
        fetch = {
            api.fetchImages().hits
        },
        saveFetchResult = { images ->
            //This will make sure deleting and inserting function work together
            //Or they will get cancelled if one of them doesn't work
            imageDb.withTransaction {
                imageDao.deleteAllImages()
                imageDao.insertImages(images)
            }
        }
    )

    suspend fun searchImages(searchQuery: String): Response<ImagesResponse> {
        return api.searchImages(API_KEY, searchQuery)
    }

}