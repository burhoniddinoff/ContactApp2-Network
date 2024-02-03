package com.example.contactappwithinternet2.presentation.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.contactappwithinternet2.R
import com.example.contactappwithinternet2.data.model.ContactUIData
import com.example.contactappwithinternet2.databinding.ScreenContactBinding
import com.example.contactappwithinternet2.presentation.viewModel.ContactViewModel
import com.example.contactappwithinternet2.presentation.viewModel.factory.ContactViewModelFactory
import com.example.contactappwithinternet2.presentation.viewModel.impl.ContactViewModelImpl

class ContactScreen : Fragment(R.layout.screen_contact) {

    private val binding by viewBinding(ScreenContactBinding::bind)
    private val viewModel: ContactViewModel by viewModels<ContactViewModelImpl> { ContactViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.errorMessageLiveData.observe(this, errorMessageObserver)
        viewModel.notConnectionLiveData.observe(this, notConnectionObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.progressLiveData.observe(viewLifecycleOwner, progressObserver)
        viewModel.contactsLiveData.observe(viewLifecycleOwner, contactsObserver)
        viewModel.emptyStateLiveData.observe(viewLifecycleOwner, emptyStateObserver)
    }

    private val errorMessageObserver = Observer<String> {

    }

    private val notConnectionObserver = Observer<Unit> {

    }

    private val progressObserver = Observer<Boolean> {

    }

    private val contactsObserver = Observer<List<ContactUIData>> {

    }

    private val emptyStateObserver = Observer<Unit> {

    }


}