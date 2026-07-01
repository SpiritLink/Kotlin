package com.example.tripapp.db

import android.content.Context
import android.database.Cursor
import android.util.Log

// dbms 를 위해 앱 곳곳에서 호출할 함수.. 일종의 dao
fun insertInfo(context: Context, email: String, phone: String?, photo: String?): Boolean {
    try {
        var db = DBHelper(context).writableDatabase
        db.execSQL(
            "insert into TB_INFO (email, phone, photo) values (?,?,?)",
            arrayOf(email, phone, photo)
        )
        db.close()
        return true
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
}

fun selectInfo(context: Context): Cursor? {
    try {
        val db = DBHelper(context).readableDatabase
        return db.rawQuery("select * from TB_INFO order by _id DESC limit 1", null)
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }
}