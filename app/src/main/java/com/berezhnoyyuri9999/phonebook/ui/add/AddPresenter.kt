package com.berezhnoyyuri9999.phonebook.ui.add

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.phonebook.RoomApplication
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.utils.REPOSITORY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddPresenter() : AddContract.AddPresenter {



    private var view : AddContract.AddView? = null



    override fun bindView(view: AddContract.AddView) {
        this.view = view
    }

    override fun unBind() {
        this.view = null
    }

    override fun saveAllDataFromEditText() {
//        roomApplication.database.getAppRoomDao().getAllNotes()

    }

    @SuppressLint("CheckResult")
    override fun insertToDb(note: AppNote) {
        REPOSITORY.insert(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.onContactCreated()
                Log.e("L", "$it")
            }, {
                Log.e("sda", "${it.message}")
            })
    }
}