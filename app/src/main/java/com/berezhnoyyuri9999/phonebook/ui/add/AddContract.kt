package com.berezhnoyyuri9999.phonebook.ui.add

import com.berezhnoyyuri9999.phonebook.data.models.AppNote

interface AddContract {

    interface AddView {
        fun onContactCreated()
    }

    interface AddPresenter {
        fun bindView(view: AddView)
        fun unBind()
        fun insertToDb(note: AppNote)
    }
}
