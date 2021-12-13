package com.nehabalaji.noteapp_ktor.ui.notes

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.nehabalaji.noteapp_ktor.R
import com.nehabalaji.noteapp_ktor.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_notes.*

class NotesFragment: BaseFragment(R.layout.fragment_notes) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabAddNote.setOnClickListener {
            findNavController().navigate(NotesFragmentDirections.actionNotesFragmentToAddEditNoteFragment(""))
        }
    }
}