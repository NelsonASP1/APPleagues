package com.nelson.appleagues.di

import com.nelson.appleagues.model.TeamList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("api/v1/json/2/search_all_teams.php?l=Spanish La Liga")
    fun getAllTeams(): Call<TeamList>

    companion object {

        var retrofitService: RetrofitService? = null

        //Create the RetrofitService instance using the retrofit.
        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.thesportsdb.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}