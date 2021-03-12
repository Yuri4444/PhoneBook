package com.berezhnoyyuri9999.phonebook.ui.add

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

class AddPresenter(var app: App) : AddContract.AddPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: AddContract.AddView? = null

    override fun bindView(view: AddContract.AddView) {
        this.view = view
    }

    override fun unBind() {
        this.view = null
    }


    override fun insertToDb(note: AppNote) {
        CoroutineScope(Main).launch {
            interactor.insert(note)
            view?.onContactCreated()
        }

    }
}


//@SuppressLint("CheckResult")
//override fun insertToDb(note: AppNote) {
//    interactor.insert(note)
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe({
//            view?.onContactCreated()
//            Log.e("L", "$it")
//        }, {
//            Log.e("sda", "${it.message}")
//        })
//
//
//}