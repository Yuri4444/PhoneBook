package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import kotlinx.coroutines.*
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
//        interactor.selectAllContactsRx()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                view?.showListPersons(it)
//            }, {
//
//            })
//
        CoroutineScope(Main).ioToUi(
            io = {
                val result = interactor.selectAllContacts()
                Log.e("result", result.toString())
                result
            },
            ui = { view?.showListPersons(it) }
        )

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

fun <T> CoroutineScope.ioToUi(
    io: suspend () -> T,
    ui: (T) -> Unit,
    exception: ((Exception) -> Unit)? = null
): Job {
    return launch(Dispatchers.IO) {
        try {
            val result = io()
            withContext(Main) {
                ui(result)
            }
        } catch (e: Exception) {
            withContext(Main) {
                exception?.invoke(e)
            }
        }
    }
}