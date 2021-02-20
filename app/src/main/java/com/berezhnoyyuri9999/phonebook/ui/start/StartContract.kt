package com.berezhnoyyuri9999.phonebook.ui.start

interface StartContract {

    interface StartView {

    }

    interface StartPresenter {
        fun clickBook()
        fun bindView(view : StartView)
        fun unBind()
        fun initDatabase(type : String, onSuccess:() -> Unit)
    }
}