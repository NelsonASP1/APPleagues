package com.nelson.appleagues.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nelson.appleagues.Team
import com.nelson.appleagues.model.TeamList
import com.nelson.appleagues.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val movieList = MutableLiveData<List<Team>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        val response = repository.getAll()
        response.enqueue(object : Callback<TeamList> {
            override fun onResponse(call: Call<TeamList>, response: Response<TeamList>) {
                movieList.postValue(response.body()?.mList)
            }

            override fun onFailure(call: Call<TeamList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}