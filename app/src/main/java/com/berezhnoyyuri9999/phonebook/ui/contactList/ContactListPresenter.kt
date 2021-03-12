package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.annotation.SuppressLint
import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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


//    @SuppressLint("CheckResult")
//    override fun showContactList() {
//        CoroutineScope(Main).async {
//            interactor.selectAllContacts()
//            view?.showListPersons(it)
//
//        }
//
//    }


    @SuppressLint("CheckResult")
    override fun showContactList() {
        interactor.selectAllContactsRx()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showListPersons(it)
            }, {

            })

        runBlocking {
            var result: List<AppNote>? = null
            async { result = interactor.selectAllContacts() }
            result?.let {
                view?.showListPersons(it)
            }

        }

//        CoroutineScope(Main).launch {
//
//            val result = interactor.selectAllContacts()
//            view?.showListPersons(it)
//        }
    }


//    override fun showContactList() {
//        CoroutineScope(Main).launch {
//            interactor.selectAllContacts()
//            view?.showListPersons(it)
//        }
//
//    }


//    override val coroutineContext: CoroutineContext
//        get() = ioToUi(
//            io = { interactor.selectAllContacts() },
//            ui = { view?.showListPersons(it) }
//        )


//        CoroutineScope(Main).launch {
//            interactor.selectAllContacts()
//            view?.showListPersons(it)
//
//        }


}


//@SuppressLint("CheckResult")
//override fun showContactList() {
//    interactor.selectAllContacts()
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe({
//            view?.showListPersons(it)
//        }, {
//
//        })
//}