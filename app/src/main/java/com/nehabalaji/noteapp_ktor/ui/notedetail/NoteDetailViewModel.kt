package com.nehabalaji.noteapp_ktor.ui.notedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.nehabalaji.noteapp_ktor.repositories.NoteRepository

class NoteDetailViewModel @ViewModelInject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    fun observeNoteByID(noteID: String) = repository.observeNoteByID(noteID)
}