package com.breens.adaninalabsandroidtets.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.breens.adaninalabsandroidtets.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
    }
}