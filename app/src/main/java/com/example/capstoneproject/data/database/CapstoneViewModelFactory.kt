package com.example.capstoneproject.data.database

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CapstoneViewModelFactory
    (private val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return CapstoneViewModel(application) as T
    }
}