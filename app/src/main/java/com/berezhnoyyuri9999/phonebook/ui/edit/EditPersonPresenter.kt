package com.berezhnoyyuri9999.phonebook.ui.edit

import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.domain.Interactor
import com.berezhnoyyuri9999.phonebook.utils.ioToUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main

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
        CoroutineScope(Main).ioToUi(
            io = { interactor.delete(note) },
            ui = { view?.onBackToListContact() }
        )
    }

    override fun update(note: AppNote) {
        CoroutineScope(Main).ioToUi(
            io = { interactor.update(note) },
            ui = { view?.onBackToListContact() }
        )
    }

}