package com.muhsanjaved.kotlin_coroutines_practice.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhsanjaved.kotlin_coroutines_practice.Models.Post
import com.muhsanjaved.kotlin_coroutines_practice.Repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository : PostRepository): ViewModel() {

    val postMutableLiveData : MutableLiveData<List<Post>> = MutableLiveData()


    fun getPost(){
        viewModelScope.launch {
            try {
                val response = postRepository.getPost()
                postMutableLiveData.value=response
                Log.d("main", "Show Data $response")
            }catch (e:Exception){
                Log.d("main", "getPost :PostViewModel")
            }

        }
    }

}