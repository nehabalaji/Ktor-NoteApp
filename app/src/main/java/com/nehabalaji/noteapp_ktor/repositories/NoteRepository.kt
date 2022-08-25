package com.nehabalaji.noteapp_ktor.repositories

import android.app.Application
import com.nehabalaji.noteapp_ktor.data.local.NoteDao
import com.nehabalaji.noteapp_ktor.data.local.entities.Note
import com.nehabalaji.noteapp_ktor.data.remote.NoteApi
import com.nehabalaji.noteapp_ktor.data.remote.requests.AccountRequest
import com.nehabalaji.noteapp_ktor.other.Resource
import com.nehabalaji.noteapp_ktor.other.checkForInternetConnection
import com.nehabalaji.noteapp_ktor.other.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val noteApi: NoteApi,
    private val context: Application
) {

    fun getAllNotes(): Flow<Resource<List<Note>>> {
        return networkBoundResource(
            query = {
                noteDao.getAllNotes()
            },
            fetch = {
                noteApi.getNotes()
            },
            saveFetchResult = { response ->
                response.body()?.let {
                    // TODO: insert notes in database
                }
            },
            shouldFetch = {
                checkForInternetConnection(context)
            }
        )
    }
    suspend fun login(email: String, password: String) = withContext(Dispatchers.IO) {
        try {
            val response = noteApi.login(AccountRequest(email, password))
            if(response.isSuccessful && response.body()!!.successful) {
                Resource.success(response.body()?.message)
            } else {
                Resource.error(response.body()?.message ?: response.message(), null)
            }
        } catch(e: Exception) {
            Resource.error("Couldn't connect to the servers. Check your internet connection", null)
        }
    }

    suspend fun register(email: String, password: String) = withContext(Dispatchers.IO) {
        try {
            val response = noteApi.register(AccountRequest(email, password))
            if(response.isSuccessful && response.body()!!.successful) {
                Resource.success(response.body()?.message)
            } else {
                Resource.error(response.body()?.message ?: response.message(), null)
            }
        } catch(e: Exception) {
            Resource.error("Couldn't connect to the servers. Check your internet connection", null)
        }
    }
}