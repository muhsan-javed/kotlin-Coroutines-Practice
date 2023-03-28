package com.muhsanjaved.kotlin_coroutines_practice

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhsanjaved.kotlin_coroutines_practice.Adapters.PostAdapter
import com.muhsanjaved.kotlin_coroutines_practice.Models.Post
import com.muhsanjaved.kotlin_coroutines_practice.Repository.PostRepository
import com.muhsanjaved.kotlin_coroutines_practice.ViewModel.PostViewModel
import com.muhsanjaved.kotlin_coroutines_practice.ViewModel.PostViewModelFactory
import com.muhsanjaved.kotlin_coroutines_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var postAdapter: PostAdapter
    lateinit var postViewModel: PostViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        val postResponse = PostRepository()
        val viewModelFactory = PostViewModelFactory(postResponse)
        postViewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)
            binding.progress.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        })
    }

    private fun initRecyclerView() {
        postAdapter = PostAdapter(this, ArrayList())

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}