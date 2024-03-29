package com.example.mainb.data.model

import android.provider.ContactsContract.CommonDataKinds.Phone

data class Profile(
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val profileImg: String
)