package com.example.contactappwithinternet2.presentation.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactappwithinternet2.domain.impl.ContactRepositoryImpl
import com.example.contactappwithinternet2.presentation.viewModel.ContactViewModel
import com.example.contactappwithinternet2.presentation.viewModel.impl.ContactViewModelImpl

@Suppress("UNCHECKED_CAST")
class ContactViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (!modelClass.isAssignableFrom(ContactViewModelImpl::class.java)) {
            return ContactViewModelImpl(ContactRepositoryImpl.getInstance()) as T
        } else throw IllegalArgumentException("Required MainViewModelImpl !")
    }

}