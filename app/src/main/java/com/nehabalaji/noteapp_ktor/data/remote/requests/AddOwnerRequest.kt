package com.nehabalaji.noteapp_ktor.data.remote.requests

data class AddOwnerRequest (
    val owner: String,
    val noteID: String
)