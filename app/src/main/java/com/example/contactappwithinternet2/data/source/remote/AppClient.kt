package com.example.contactappwithinternet2.data.source.remote

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.contactappwithinternet2.data.source.remote.api.ContactApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClient private constructor() {

    companion object {
        lateinit var api: ContactApi

        fun init(context: Context) {
            val okHttpClient =
                OkHttpClient.Builder().addInterceptor(ChuckerInterceptor(context)).build()

            val retrofit = Retrofit.Builder().baseUrl("https://63e3-82-215-92-25.ngrok-free.app") //
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()

            api = retrofit.create(ContactApi::class.java)
        }

    }

}