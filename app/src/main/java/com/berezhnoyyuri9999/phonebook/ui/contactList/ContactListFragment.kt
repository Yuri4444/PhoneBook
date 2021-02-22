package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.adapter.ItemAdapter
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_contact_list.*


class ContactListFragment : Fragment(), ContactListContract.ItemView {

    private val mPresenter by lazy {
        ContactListPresenter()
    }

    private lateinit var mAdapter : ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mPresenter.fetchListItemAdapter()

        btnAddNote.setOnClickListener {
            mPresenter.clickAddNewNote()
        }

        btnBackToStart.setOnClickListener {
            mPresenter.clickBackToStart()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = ItemAdapter()
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


    companion object {
        fun clickItem(note : AppNote) {
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP_ACTIVITY.navController.navigate(R.id.action_listFragment_to_noteFragment, bundle)
        }
    }

}