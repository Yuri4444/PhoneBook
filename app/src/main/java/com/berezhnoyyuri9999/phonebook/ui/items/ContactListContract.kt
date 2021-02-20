package com.berezhnoyyuri9999.phonebook.ui.items

import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import io.reactivex.Single

interface ContactListContract {

    interface ItemView {
        fun showListPersons(list : List<AppNote>)
    }

    interface ItemPresenter {

        fun fetchListItemAdapter()

        fun clickAddNewNote()
        fun clickBackToStart()
        fun bindView(view : ItemView)
        fun unBind()

        fun showContactList()
    }
}