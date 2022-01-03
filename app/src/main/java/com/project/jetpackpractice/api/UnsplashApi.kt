package com.project.jetpackpractice.api

import androidx.viewbinding.BuildConfig

interface UnsplashApi {

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig
    }
}