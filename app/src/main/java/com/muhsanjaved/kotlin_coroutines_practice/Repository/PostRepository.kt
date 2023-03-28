package com.muhsanjaved.kotlin_coroutines_practice.Repository

import com.muhsanjaved.kotlin_coroutines_practice.Models.Post
import com.muhsanjaved.kotlin_coroutines_practice.network.RetrofitBuilder

class PostRepository {

    suspend fun getPost():List<Post> = RetrofitBuilder.api.getPost()

}