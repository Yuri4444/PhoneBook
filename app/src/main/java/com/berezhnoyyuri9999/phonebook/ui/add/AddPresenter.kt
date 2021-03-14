package com.berezhnoyyuri9999.phonebook.ui.add

import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import com.berezhnoyyuri9999.phonebook.utils.ioToUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main

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

        CoroutineScope(Main).ioToUi(
            io = { interactor.insert(note) },
            ui = { view?.onContactCreated() }
        )


    }
}
