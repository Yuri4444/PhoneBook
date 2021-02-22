package com.berezhnoyyuri9999.phonebook.ui.note

import android.os.Bundle
import android.text.Editable
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.NavHost
import androidx.navigation.fragment.navArgs
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_add_person.*
import kotlinx.android.synthetic.main.fragment_note.*
import kotlinx.android.synthetic.main.fragment_note.view.*

class NoteFragment : Fragment(), NoteContract.NoteView {

    private val mPresenter by lazy {
        NotePresenter()
    }

    private lateinit var mCurrentNote : AppNote

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

        initialized()

        btn_change_item.setOnClickListener {

            onBackToListContact()
        }

    }

    override fun onStop() {
        super.onStop()
        mPresenter.unBindView()
    }

    private fun initialized() {
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

    override fun onBackToListContact() {


        mCurrentNote.name = ed_name_change.text.toString()
        mCurrentNote.surname = ed_surname_change.text.toString()
        mCurrentNote.number = ed_phone_number_change.text.toString()

        mPresenter.update(mCurrentNote)

        APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_listFragment)
    }




}