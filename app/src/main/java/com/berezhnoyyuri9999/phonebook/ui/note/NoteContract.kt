package com.berezhnoyyuri9999.phonebook.ui.note

import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import io.reactivex.internal.operators.single.SingleDoOnSuccess

interface NoteContract {

    interface NoteView {
        fun onContactDeleted()
    }

    interface NotePresenter {

        fun bindView(view : NoteView)
        fun unBindView()

        fun delete(note : AppNote)
    }

}