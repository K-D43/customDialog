package com.example.customdialog.db

class Repository(private var dao:DBdao) {

    fun insert(item:Model){
        dao.insert(item)
    }

}