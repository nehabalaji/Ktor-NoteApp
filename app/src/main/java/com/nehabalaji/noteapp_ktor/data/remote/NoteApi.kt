package com.nehabalaji.noteapp_ktor.data.remote

import com.nehabalaji.noteapp_ktor.data.remote.responses.SimpleResponse
import com.nehabalaji.noteapp_ktor.data.local.entities.Note
import com.nehabalaji.noteapp_ktor.data.remote.requests.AccountRequest
import com.nehabalaji.noteapp_ktor.data.remote.requests.AddOwnerRequest
import com.nehabalaji.noteapp_ktor.data.remote.requests.DeleteNoteRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NoteApi {

    @POST("/register")
    suspend fun register(
        @Body registerRequest: AccountRequest //@Body is used to tell retrofit that it should attach the parameter as json
    ): Response<SimpleResponse>

    @POST("/login")
    suspend fun login(
        @Body loginRequest: AccountRequest //@Body is used to tell retrofit that it should attach the parameter as json
    ): Response<SimpleResponse>

    @POST("/addNote")
    suspend fun addNote(
        @Body note: Note
    ): Response<ResponseBody>

    @POST("/deleteNote")
    suspend fun deleteNote(
        @Body deleteNoteRequest: DeleteNoteRequest
    ): Response<ResponseBody>

    @POST("/addOwnerToNote")
    suspend fun addOwnerToNote(
        @Body addOwnerRequest: AddOwnerRequest
    ): Response<SimpleResponse>

    @GET("/getNotes")
    suspend fun getNotes(): Response<List<Note>>
}