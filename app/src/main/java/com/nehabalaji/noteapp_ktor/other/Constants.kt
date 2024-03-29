package com.nehabalaji.noteapp_ktor.other

object Constants {

    const val DATABASE_NAME = "notes_db"
    const val BASE_URL = "http://192.168.0.106:8001"

    const val KEY_LOGGED_IN_EMAIL = "KEY_LOGGED_IN_EMAIL"
    const val KEY_PASSWORD = "KEY_PASSWORD"

    const val DEFAULT_NOTE_COLOR = "FFA500"

    const val NO_EMAIL = "NO_EMAIL"
    const val NO_PASSWORD = "NO_PASSWORD"

    const val ENCRYPTED_SHARED_PREFERENCE_NAME = "enc_shared_pref"
    val IGNORE_AUTH_URLS = listOf("/login", "/register")
}