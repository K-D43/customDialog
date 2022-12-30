package com.example.customdialog

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    lateinit var builder: Builder
    lateinit var viewModel:viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao=DbModel.getInstance(applicationContext).dbDao()
        val repossitory=Repository(dao)
        viewModel=ViewModelProvider(this,viewModelFactory(repossitory)).get(viewModel::class.java)

        binding.check.setOnClickListener {
            DialogBox(this,
            object:DialogInterface{
                override fun addItemClicked(item: Model) {
                    viewModel.insert(item)
                }
            }).show()
        }


    }

    var selectedIndex=0

    private fun showSnakebar(msg:String){
        Snackbar.make(binding.root,msg,Snackbar.LENGTH_SHORT).show()
    }

    fun showConfirmationDialog(view: View) {

        val ringtone= arrayOf("None","yoyo","Sunrise","Yhaha vaha","Happy morning","Homecoming","Thithi","Legend","Horor")
        var selectItem=ringtone[selectedIndex]
        MaterialAlertDialogBuilder(this)
            .setTitle("Phone Ringtone")
            .setSingleChoiceItems(ringtone,selectedIndex){dialog,which->
                selectedIndex=which
                selectItem=ringtone[which]

            }
            .setPositiveButton("Yes"){dialog,which->
                showSnakebar("$selectItem selected")
            }
            .setNeutralButton("Cancel"){dialog,which->

            }
            .setNegativeButton("Cancel"){dialog,which->

            }
            .show()
    }
}