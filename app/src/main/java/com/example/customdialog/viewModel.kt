package com.example.customdialog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customdialog.db.DbModel
import com.example.customdialog.db.Model
import com.example.customdialog.db.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewModel(var repository: Repository):ViewModel()
{

    fun insert(item:Model)= CoroutineScope(Dispatchers.IO).launch {
        repository.insert(item)
    }
}