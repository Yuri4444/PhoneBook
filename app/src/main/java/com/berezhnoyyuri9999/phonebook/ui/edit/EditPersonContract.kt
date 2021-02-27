package com.berezhnoyyuri9999.phonebook.ui.edit

import com.berezhnoyyuri9999.phonebook.data.models.AppNote

interface EditPersonContract {

    interface EditPersonView {
        fun onBackToListContact()
    }

    interface EditPersonPresenter {
        fun bindView(view: EditPersonView)
        fun unBindView()
        fun delete(note: AppNote)
        fun update(note: AppNote)
    }
}