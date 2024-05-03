package com.example.mainb.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mainb.data.model.Profile

class ProfileViewModel : ViewModel() {
    val profileData =
        MutableLiveData(
            Profile(
                name = "Muhammad Syihab Habibi",
                username = "Ilthidin",
                email = "muhammad.syihab@std.unissula.ac.id",
                phone = "089668080668",
                profileImg = "https://github.com/Ilthidin/food_assets/blob/main/New%20Photo.jpg?raw=true",
            ),
        )

    val isEditMode = MutableLiveData(false)

    fun changeEditMode() {
        val currentValue = isEditMode.value ?: false
        isEditMode.postValue(!currentValue)
    }
}
