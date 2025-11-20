package com.teixeira0x.savmoney

import android.app.Application
import androidx.room.Room
import com.teixeira0x.savmoney.data.db.SavDatabase

class App: Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    val db by lazy {
        Room.databaseBuilder(
            this,
            SavDatabase::class.java, "app-dp"
        ).build()
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}