package com.example.notesapp.feature_note.domain.use_case

import com.example.notesapp.feature_note.domain.model.Note
import com.example.notesapp.feature_note.domain.repository.NoteRepository
import com.example.notesapp.feature_note.domain.util.OrderProperty
import com.example.notesapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(
        noteOrderProperty: OrderProperty = OrderProperty.Date(OrderType.Descending)
    ): Flow<List<Note>> {

        // how to utilize a flow<list> properly. treat it as you would a regular list
        return repository.getNotes().map { notesList ->
            when(noteOrderProperty.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrderProperty) {
                        is OrderProperty.Date -> notesList.sortedBy { it.timeStamp }
                        is OrderProperty.Title -> notesList.sortedBy { it.title }
                        is OrderProperty.Color -> notesList.sortedBy { it.color }
                    }
                }

                is OrderType.Descending -> {
                    when(noteOrderProperty) {
                        is OrderProperty.Date -> notesList.sortedByDescending{ it.timeStamp }
                        is OrderProperty.Title -> notesList.sortedByDescending{ it.title }
                        is OrderProperty.Color -> notesList.sortedByDescending{ it.color }
                    }
                }
            }
        }
    }
}