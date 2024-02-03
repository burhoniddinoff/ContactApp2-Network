package com.example.contactappwithinternet2.data.source.remote.api

import com.example.contactappwithinternet2.data.source.remote.responce.ContactResponce
import retrofit2.Call
import retrofit2.http.GET

interface ContactApi {

    @GET("api/v1/contact")
    fun getAllContacts() : Call<List<ContactResponce>>

}