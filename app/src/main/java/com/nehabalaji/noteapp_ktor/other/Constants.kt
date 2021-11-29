package com.nehabalaji.noteapp_ktor.other

object Constants {

    const val DATABASE_NAME = "notes_db"
    const val BASE_URL = "http://192.168.0.106:8001"
    const val ENCRYPTED_SHARED_PREFERENCE_NAME = "enc_shared_pref"
    val IGNORE_AUTH_URLS = listOf("/login", "/register")
}