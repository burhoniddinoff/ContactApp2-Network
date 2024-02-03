package com.example.contactappwithinternet2.presentation.viewModel

import androidx.lifecycle.LiveData
import com.example.contactappwithinternet2.data.model.ContactUIData

interface ContactViewModel {
    val progressLiveData: LiveData<Boolean>
    val contactsLiveData: LiveData<List<ContactUIData>>
    val errorMessageLiveData: LiveData<String>
    val notConnectionLiveData: LiveData<Unit>
    val emptyStateLiveData: LiveData<Unit>

    fun loadContacts()

}