package com.example.customdialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.customdialog.db.Repository

class viewModelFactory(var repository: Repository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel(repository) as T
    }
}