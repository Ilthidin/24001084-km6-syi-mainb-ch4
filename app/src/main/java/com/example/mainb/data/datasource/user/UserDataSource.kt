package com.example.mainb.data.datasource.user

import com.example.mainb.data.source.local.pref.UserPreference

interface UserDataSource {
    fun isUsingDarkMode(): Boolean

    fun setUsingDarkMode(isUsingDarkMode: Boolean)
}

class UserPreferenceDataSource(private val userPreference: UserPreference) : UserDataSource {
    override fun isUsingDarkMode(): Boolean {
        return userPreference.isUsingDarkMode()
    }

    override fun setUsingDarkMode(isUsingDarkMode: Boolean) {
        userPreference.setUsingDarkMode(isUsingDarkMode)
    }
}
