package com.muhsanjaved.kotlin_coroutines_practice.network

import com.muhsanjaved.kotlin_coroutines_practice.Models.Post
import retrofit2.http.GET

interface Api {

    @GET("posts")
    suspend fun getPost(): List<Post>



}