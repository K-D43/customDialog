package com.example.customdialog.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface DBdao {

    @Insert
    fun insert(item:Model)

}