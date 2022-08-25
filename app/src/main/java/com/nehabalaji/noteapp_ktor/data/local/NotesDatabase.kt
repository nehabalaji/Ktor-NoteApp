package com.nehabalaji.noteapp_ktor.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nehabalaji.noteapp_ktor.data.local.entities.LocallyDeletedNoteID
import com.nehabalaji.noteapp_ktor.data.local.entities.Note

@Database(entities = [Note::class, LocallyDeletedNoteID::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}