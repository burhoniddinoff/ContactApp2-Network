package com.example.contactappwithinternet2.data.source.local.entitiy

import androidx.room.Entity
import com.example.contactappwithinternet2.data.model.StatusEnum

@Entity
data class ContactEntity(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val status: Int, // StatusEnum ?!
)