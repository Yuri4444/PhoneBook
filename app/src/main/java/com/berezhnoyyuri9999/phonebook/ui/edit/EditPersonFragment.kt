package com.berezhnoyyuri9999.phonebook.ui.edit

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.phonebook.BookApplication
import com.berezhnoyyuri9999.phonebook.ContactNavController
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.utils.showToast
import kotlinx.android.synthetic.main.fragment_note.*

class EditPersonFragment : Fragment(), EditPersonContract.EditPersonView {

    private val mPresenter by lazy {
        EditPersonPresenter(BookApplication.getApp(context))
    }

    private lateinit var contactNavController : ContactNavController

    private lateinit var mCurrentNote : AppNote

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactNavController = context as ContactNavController
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note, container, false)


        mCurrentNote = arguments?.getSerializable("note") as AppNote

        return view
    }

    override fun onStart() {
        super.onStart()
        mPresenter.bindView(this)

        dataFromContactList()

        btn_change_item.setOnClickListener {

            changeData()
        }

    }

    override fun onStop() {
        super.onStop()
        mPresenter.unBindView()
    }

    private fun dataFromContactList() {

        setHasOptionsMenu(true)
        ed_name_change.setText(mCurrentNote.name)
        ed_surname_change.setText(mCurrentNote.surname)
        ed_phone_number_change.setText(mCurrentNote.number)

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.btn_delete -> {
                mPresenter.delete(mCurrentNote)
            }
        }

        return super.onOptionsItemSelected(item)

    }

    private fun changeData() {

        mCurrentNote.name = ed_name_change.text.toString()
        mCurrentNote.surname = ed_surname_change.text.toString()
        mCurrentNote.number = ed_phone_number_change.text.toString()

        if(mCurrentNote.name.isEmpty() || mCurrentNote.surname.isEmpty() || mCurrentNote.number.isEmpty()) {
            context?.showToast(getString(R.string.enter_all_filds))
        } else {
            mPresenter.update(mCurrentNote)
        }

    }

    override fun onBackToListContact() {

        contactNavController.navController().navigate(R.id.action_noteFragment_to_listFragment)

    }

}