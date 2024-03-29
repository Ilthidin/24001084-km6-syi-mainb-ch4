package com.example.mainb.data.datasource.user

interface UserDataSource {
    fun isUsingDarkMode(): Boolean
    fun setUsingDarkMode(isUsingDarkMode: Boolean)
}