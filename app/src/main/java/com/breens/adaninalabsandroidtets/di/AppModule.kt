package com.breens.adaninalabsandroidtets.di

import android.app.Application
import androidx.room.Room
import com.breens.adaninalabsandroidtets.api.PixabayApi
import com.breens.adaninalabsandroidtets.data.local.ImagesDatabase
import com.breens.adaninalabsandroidtets.repositories.ImageRepository
import com.breens.adaninalabsandroidtets.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(loggingInterceptor())
            .build()

    @Provides
    @Singleton
    fun providePixabayApi(retrofit: Retrofit) : PixabayApi =
        retrofit.create(PixabayApi::class.java)

    @Provides
    @Singleton
    fun provideImagesDatabase(app: Application): ImagesDatabase =
        Room.databaseBuilder(app, ImagesDatabase::class.java, "images_database")
            .build()

}

fun loggingInterceptor(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}