package com.example.customdialog.db

class Repository(private var db:DbModel) {

    fun insert(item:Model){
        db.dbDao().insert(item)
    }

}