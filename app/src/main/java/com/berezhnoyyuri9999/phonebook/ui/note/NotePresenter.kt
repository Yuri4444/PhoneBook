package com.berezhnoyyuri9999.phonebook.ui.note

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.utils.REPOSITORY
import com.berezhnoyyuri9999.phonebook.utils.showToast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NotePresenter : NoteContract.NotePresenter {

    private var view : NoteContract.NoteView? = null

    override fun bindView(view: NoteContract.NoteView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }



    @SuppressLint("CheckResult")
    override fun delete(note: AppNote) {
        REPOSITORY.delete(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                view?.onContactDeleted()

                Log.e("Delete", "$it")
                showToast("Контакт удален")
            }, {

            })
    }
}