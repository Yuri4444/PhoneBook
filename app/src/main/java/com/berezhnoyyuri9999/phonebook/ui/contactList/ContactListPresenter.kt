package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import com.berezhnoyyuri9999.phonebook.utils.ioToUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main

class ContactListPresenter(var app: App) : ContactListContract.ItemPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: ContactListContract.ItemView? = null

    override fun bindView(view: ContactListContract.ItemView) {
        this.view = view
    }

    override fun unBind() {
        this.view = null
    }

    @SuppressLint("CheckResult")
    override fun showContactList() {

        CoroutineScope(Main).ioToUi(
            io = {
                val result = interactor.selectAllContacts()
                Log.e("result", result.toString())
                result
            },
            ui = { view?.showListPersons(it) }
        )

    }

}
