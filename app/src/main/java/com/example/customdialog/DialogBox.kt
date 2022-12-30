package com.example.customdialog

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.customdialog.databinding.ActivityDialogBoxBinding
import com.example.customdialog.db.Model

class DialogBox(context: Context,val dialogListener:DialogInterface) : AppCompatDialog(context
) {
    lateinit var binding: ActivityDialogBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDialogBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.yes.setOnClickListener {
            val name=binding.editName.text.toString()
            if (name.isEmpty()){
                Toast.makeText(context,"Please enter your name",Toast.LENGTH_SHORT).show()
            }
            val item=Model(null,name)
            dialogListener.addItemClicked(item)
            dismiss()
        }
        binding.no.setOnClickListener {
            cancel()
        }

    }
}