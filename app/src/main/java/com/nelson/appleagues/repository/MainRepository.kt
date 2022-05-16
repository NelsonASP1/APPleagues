package com.nelson.appleagues.repository

import com.nelson.appleagues.di.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAll() = retrofitService.getAllTeams()
}