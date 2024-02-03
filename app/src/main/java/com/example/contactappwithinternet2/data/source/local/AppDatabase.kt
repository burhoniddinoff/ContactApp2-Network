package com.example.contactappwithinternet2.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactappwithinternet2.data.source.local.dao.ContactDao
import com.example.contactappwithinternet2.data.source.local.entitiy.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        private lateinit var instance: AppDatabase

        fun init(context: Context) {
            if (!(::instance.isInitialized)) instance =
                Room.databaseBuilder(context, AppDatabase::class.java, "contact.db")
                    .allowMainThreadQueries().build()
        }

        fun getInstance() = instance


    }

}