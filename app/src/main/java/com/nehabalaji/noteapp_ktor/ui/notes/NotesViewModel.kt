package com.nehabalaji.noteapp_ktor.ui.notes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.nehabalaji.noteapp_ktor.data.local.entities.Note
import com.nehabalaji.noteapp_ktor.other.Event
import com.nehabalaji.noteapp_ktor.other.Resource
import com.nehabalaji.noteapp_ktor.repositories.NoteRepository

class NotesViewModel @ViewModelInject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val _forceUpdate = MutableLiveData<Boolean>(false)

    private val _allNotes = _forceUpdate.switchMap {
        repository.getAllNotes().asLiveData(viewModelScope.coroutineContext)
    }.switchMap {
        MutableLiveData(Event(it))
    }
    val allNotes: LiveData<Event<Resource<List<Note>>>> = _allNotes

    fun syncAllNotes() = _forceUpdate.postValue(true)
}