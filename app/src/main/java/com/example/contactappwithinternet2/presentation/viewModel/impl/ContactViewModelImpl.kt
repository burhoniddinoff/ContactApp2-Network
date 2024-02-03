package com.example.contactappwithinternet2.presentation.viewModel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactappwithinternet2.data.model.ContactUIData
import com.example.contactappwithinternet2.domain.ContactRepository
import com.example.contactappwithinternet2.presentation.viewModel.ContactViewModel

class ContactViewModelImpl(val repository: ContactRepository) : ViewModel(), ContactViewModel {
    override val progressLiveData = MutableLiveData<Boolean>()
    override val contactsLiveData = MutableLiveData<List<ContactUIData>>()
    override val errorMessageLiveData = MutableLiveData<String>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val emptyStateLiveData = MutableLiveData<Unit>()

    override fun loadContacts() {
        // ...
    }

}