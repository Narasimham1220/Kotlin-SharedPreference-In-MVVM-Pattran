package com.example.sampletask.utils

import android.content.Context
import android.content.SharedPreferences

private const val KEY_USERNAME = "key_username"
private const val KEY_PASSWORD = "key_password"
private const val KEY_TIMEZONE = "key_timezone"

class PreferenceProvider(context: Context) {

    private val appcontext = context.applicationContext
    private val preference: SharedPreferences
        get() = androidx.preference.PreferenceManager.getDefaultSharedPreferences(
            appcontext
        )

    fun save(username: String, pwd: String, timezone: String) {
        preference.edit().putString(KEY_USERNAME, username).putString(KEY_PASSWORD, pwd)
            .putString(KEY_TIMEZONE, timezone).apply()
    }

    fun get(key: String): String? {
        return preference.getString(key, null)
    }
}