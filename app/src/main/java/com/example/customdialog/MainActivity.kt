package com.example.customdialog

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModelProvider
import com.example.customdialog.databinding.ActivityMainBinding
import com.example.customdialog.db.DbModel
import com.example.customdialog.db.Model
import com.example.customdialog.db.Repository
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
//    lateinit var viewModel:viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao=DbModel.getInstance(applicationContext).dbDao()
        val repossitory=Repository(dao)
        val viewModel=ViewModelProvider(this,viewModelFactory(repossitory))[viewModel::class.java]

        binding.check.setOnClickListener {
            DialogBox(this,
            object:DialogInterface{
                override fun addItemClicked(item: Model) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}