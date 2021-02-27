package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.phonebook.BookApplication
import com.berezhnoyyuri9999.phonebook.MainActivityBridge
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.adapter.ItemAdapter
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import kotlinx.android.synthetic.main.fragment_contact_list.*


class ContactListFragment : Fragment(), ContactListContract.ItemView {

    private val mPresenter by lazy {
        ContactListPresenter(BookApplication.getApp(context))
    }

    private lateinit var mainActivityBridge: MainActivityBridge

    private val mAdapter by lazy {
        ItemAdapter { pos, item ->
            val bundle = Bundle()
            bundle.putSerializable("note", item)
            mainActivityBridge.navController()
                .navigate(R.id.action_listFragment_to_editPersonFragment, bundle)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivityBridge = context as MainActivityBridge
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnAddNote.setOnClickListener {
            clickAddNewNote()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = mAdapter
        mPresenter.showContactList()
    }

    override fun showListPersons(list: List<AppNote>) {
        val listRevers = list.asReversed()
        mAdapter.setData(listRevers)
    }

    override fun onStart() {
        super.onStart()
        mPresenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        mPresenter.unBind()
    }

    private fun clickAddNewNote() {
        mainActivityBridge.navController().navigate(R.id.action_listFragment_to_addPersonFragment)
    }
}
