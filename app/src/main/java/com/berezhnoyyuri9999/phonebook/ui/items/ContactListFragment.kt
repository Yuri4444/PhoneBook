package com.berezhnoyyuri9999.phonebook.ui.items

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.adapter.ItemAdapter
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import kotlinx.android.synthetic.main.fragment_contact_list.*


class ContactListFragment : Fragment(), ContactListContract.ItemView {

    private val mPresenter by lazy {
        ContactListPresenter()
    }

    private lateinit var mAdapter : ItemAdapter

    private lateinit var mRecyclerView : RecyclerView

    private lateinit var listNotes : AppNote

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

    @SuppressLint("CheckResult")
    override fun showListPersons(list: List<AppNote>) {

        mAdapter = ItemAdapter()
        mRecyclerView = recyclerView
        val rList = list.asReversed()
        mAdapter.setData(rList)


    }

    override fun onStart() {
        super.onStart()
        mPresenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        mPresenter.unBind()
    }

}