package com.example.tripapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// 앱의 데이터베이스 관리적인 코드(테이블 생성, 변경) 추상화 ...
class DBHelper(context: Context) : SQLiteOpenHelper(context, "testdb", null, 1) {
    // 앱 인스톨 후 최초 한번, 앱 업데이트에도 호출안된다 ..
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table TB_INFO (" +
        "_id integer primary key autoincrement," +
        "email not null," +
        "phone," +
        "photo)")
    }

    // 상위 생성자에 전달한 db version 이 변경될 때마다 ..
    override fun onUpgrade(
        p0: SQLiteDatabase?,
        p1: Int,
        p2: Int
    ) {
        TODO("Not yet implemented")
    }
}