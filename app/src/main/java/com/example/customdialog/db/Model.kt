package com.example.customdialog.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Model(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val name:String
)