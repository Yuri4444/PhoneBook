package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.annotation.SuppressLint
import android.os.Bundle
import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import com.berezhnoyyuri9999.phonebook.utils.ioToUi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

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
        interactor.selectAllContacts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showListPersons(it)
            }, {

            })
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