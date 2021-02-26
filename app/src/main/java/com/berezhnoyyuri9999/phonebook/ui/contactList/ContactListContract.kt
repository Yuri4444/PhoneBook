package com.berezhnoyyuri9999.phonebook.ui.contactList

import com.berezhnoyyuri9999.phonebook.data.models.AppNote

interface ContactListContract {

    interface ItemView {
        fun showListPersons(list : List<AppNote>)

    }

    interface ItemPresenter {


        fun bindView(view : ItemView)
        fun unBind()

        fun showContactList()
    }
}