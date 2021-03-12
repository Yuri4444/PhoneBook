package com.berezhnoyyuri9999.phonebook.ui.edit

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class EditPersonPresenter(var app: App) :
    EditPersonContract.EditPersonPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: EditPersonContract.EditPersonView? = null

    override fun bindView(view: EditPersonContract.EditPersonView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }

    override fun delete(note: AppNote) {
        CoroutineScope(Main).launch {
            interactor.delete(note)
            view?.onBackToListContact()
        }
    }

    override fun update(note: AppNote) {
        CoroutineScope(Main).launch {
            interactor.update(note)
            view?.onBackToListContact()
        }
    }

}


//@SuppressLint("CheckResult")
//override fun delete(note: AppNote) {
//    interactor.delete(note)
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe({
//            view?.onBackToListContact()
//            Log.e("Delete", "$it")
//        }, {
//
//        })
//}
//
//@SuppressLint("CheckResult")
//override fun update(note: AppNote) {
//    interactor.update(note)
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe({
//            view?.onBackToListContact()
//        }, {
//        })
//}
