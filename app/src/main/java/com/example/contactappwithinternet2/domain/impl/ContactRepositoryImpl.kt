package com.example.contactappwithinternet2.domain.impl

import com.example.contactappwithinternet2.data.source.remote.AppClient
import com.example.contactappwithinternet2.data.source.remote.responce.ContactResponce
import com.example.contactappwithinternet2.data.source.remote.responce.ErrorResponce
import com.example.contactappwithinternet2.domain.ContactRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactRepositoryImpl private constructor() : ContactRepository {

    companion object {
        private lateinit var instance: ContactRepository

        fun init() {
            if (!(::instance.isInitialized)) instance = ContactRepositoryImpl()
        }

        fun getInstance() = instance
    }

    private val api = AppClient.api
    private val gson = Gson()


    override fun getAllContact(
        successBlock: (List<ContactResponce>) -> Unit,
        errorBlock: (String) -> Unit,
    ) {
        api.getAllContacts().enqueue(object : Callback<List<ContactResponce>> {
            override fun onResponse(
                call: Call<List<ContactResponce>>,
                response: Response<List<ContactResponce>>,
            ) {
                if (response.isSuccessful && response.body() != null) {
                    successBlock.invoke(response.body()!!)
                } else {
                    if (response.body() != null) {
                        val data = gson.fromJson(
                            response.errorBody()!!.string(),
                            ErrorResponce::class.java
                        )
                        errorBlock.invoke(data.message)
                    } else {
                        errorBlock.invoke("Unknown message!")
                    }
                }
            }

            override fun onFailure(call: Call<List<ContactResponce>>, t: Throwable) {
                t.message?.let { errorBlock.invoke(it) }
//                errorBlock.invoke(t.message!!)
            }

        })
    }
}