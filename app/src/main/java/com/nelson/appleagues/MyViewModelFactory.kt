package com.nelson.appleagues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nelson.appleagues.repository.MainRepository

class MyViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TeamViewModel::class.java)) {
            TeamViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}