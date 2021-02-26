package com.berezhnoyyuri9999.phonebook.ui.note

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NotePresenter(var app: App) : NoteContract.NotePresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: NoteContract.NoteView? = null

    override fun bindView(view: NoteContract.NoteView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }

    @SuppressLint("CheckResult")
    override fun delete(note: AppNote) {
        interactor.delete(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                view?.onBackToListContact()

                Log.e("Delete", "$it")
//                showToast("Контакт удален")
            }, {

            })
    }

    @SuppressLint("CheckResult")
    override fun update(note: AppNote) {
        interactor.update(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                view?.onBackToListContact()
//                showToast("Контакт изменен")

            }, {

            })
    }

}