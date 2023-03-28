package com.muhsanjaved.kotlin_coroutines_practice.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhsanjaved.kotlin_coroutines_practice.Repository.PostRepository

class PostViewModelFactory(private val postRepository : PostRepository)  : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }
}