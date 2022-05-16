package com.nelson.appleagues

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.nelson.appleagues.MainAdapter
import com.nelson.appleagues.MyViewModelFactory
import com.nelson.appleagues.TeamViewModel
import com.nelson.appleagues.databinding.TeamFragmentBinding
import com.nelson.appleagues.di.RetrofitService
import com.nelson.appleagues.repository.MainRepository

class TeamFragment : Fragment() {

    private lateinit var binding: TeamFragmentBinding
    private lateinit var viewModel: TeamViewModel
    private var adapter= MainAdapter()
    private val TAG = "MainActivity"

    private val retrofitService = RetrofitService.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TeamFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setUp()
    }

    private fun setupRecyclerView() {
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerview.adapter = adapter
    }


    private fun setUp(){
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                TeamViewModel::class.java
            )
        viewModel.success.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })
        viewModel.getAllMovies()
    }
}