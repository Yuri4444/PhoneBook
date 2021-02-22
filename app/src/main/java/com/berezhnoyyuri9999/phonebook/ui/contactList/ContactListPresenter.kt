package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.annotation.SuppressLint
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.utils.APP_ACTIVITY
import com.berezhnoyyuri9999.phonebook.utils.REPOSITORY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ContactListPresenter : ContactListContract.ItemPresenter {



    private var view : ContactListContract.ItemView? = null


    override fun fetchListItemAdapter() {

    }

    override fun clickAddNewNote() {
        APP_ACTIVITY.navController.navigate(R.id.action_listFragment_to_addPersonFragment)
    }

    override fun clickBackToStart() {
        APP_ACTIVITY.navController.navigate(R.id.action_listFragment_to_startFragment)
    }

    override fun bindView(view: ContactListContract.ItemView) {
        this.view = view
    }

    override fun unBind() {
        this.view = null
    }

    @SuppressLint("CheckResult")
    override fun showContactList()  {
        REPOSITORY.selectAllContacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showListPersons(it)
            }, {

            })
    }
}