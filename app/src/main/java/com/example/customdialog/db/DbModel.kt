package com.example.customdialog.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Model::class],version=1, exportSchema = false)
abstract class DbModel: RoomDatabase() {

    abstract fun dbDao():DBdao

    companion object{

        @Volatile
        private var INSTANCE:DbModel?=null

        fun getInstance(context: Context):DbModel{
            if(INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context,DbModel::class.java,"databaseForName").build()
                }
            }
            return INSTANCE!!
        }
    }
}