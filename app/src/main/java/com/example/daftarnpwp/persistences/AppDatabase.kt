package com.example.daftarnpwp.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daftarnpwp.model.DaftarNPWP

@Database(entities = [DaftarNPWP::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DaftarNPWPDao() : DaftarNPWPDao
}

