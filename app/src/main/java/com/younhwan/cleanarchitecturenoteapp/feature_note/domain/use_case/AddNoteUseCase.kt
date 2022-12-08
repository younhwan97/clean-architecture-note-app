package com.younhwan.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.younhwan.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.younhwan.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.younhwan.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()){
            throw InvalidNoteException("The tile of the note can't be empty.")
        }

        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repository.insertNote(note)
    }

}