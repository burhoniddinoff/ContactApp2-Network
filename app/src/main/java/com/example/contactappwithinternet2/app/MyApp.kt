package com.example.contactappwithinternet2.app

import android.app.Application
import com.example.contactappwithinternet2.data.source.local.AppDatabase
import com.example.contactappwithinternet2.data.source.remote.AppClient
import com.example.contactappwithinternet2.domain.impl.ContactRepositoryImpl
import timber.log.Timber

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        ContactRepositoryImpl.init()
        AppClient.init(this)
        AppDatabase.init(this)
    }

}