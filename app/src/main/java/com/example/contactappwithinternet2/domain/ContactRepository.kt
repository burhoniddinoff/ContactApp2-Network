package com.example.contactappwithinternet2.domain

import com.example.contactappwithinternet2.data.source.remote.responce.ContactResponce

interface ContactRepository {

    fun getAllContact(successBlock: (List<ContactResponce>) -> Unit, errorBlock: (String) -> Unit)

}