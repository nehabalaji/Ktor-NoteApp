package com.nehabalaji.noteapp_ktor.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nehabalaji.noteapp_ktor.data.local.entities.LocallyDeletedNoteID
import com.nehabalaji.noteapp_ktor.data.local.entities.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("DELETE FROM notes WHERE id = :noteId")
    suspend fun deleteNoteById(noteId: String)

    @Query("DELETE FROM notes WHERE isSynced = 1")
    suspend fun deleteAllSyncedNotes()

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun observeNoteById(noteId: String): LiveData<Note>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNoteById(noteId: String): Note?

    @Query("SELECT * FROM notes ORDER BY date DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE isSynced = 0")
    suspend fun getAllUnsyncedNotes(): List<Note>

    @Query("SELECT * FROM locally_deleted_note_ids")
    suspend fun getAllLocallyDeletedNoteIDs(): List<LocallyDeletedNoteID>

    @Query("DELETE FROM locally_deleted_note_ids WHERE deletedNoteID = :deletedNoteID")
    suspend fun deleteLocallyDeletedNoteID(deletedNoteID: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocallyDeletedNoteID(locallyDeletedNoteID: LocallyDeletedNoteID)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()
}