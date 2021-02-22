package com.berezhnoyyuri9999.phonebook.ui.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.fragment_note.*

class NoteFragment : Fragment(), NoteContract.NoteView {

    private val mPresenter by lazy {
        NotePresenter()
    }

    private lateinit var mCurrentNote : AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mCurrentNote = arguments?.getSerializable("note") as AppNote

        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onStart() {
        super.onStart()
        mPresenter.bindView(this)

        initialized()

    }

    override fun onStop() {
        super.onStop()
        mPresenter.unBindView()
    }

    private fun initialized() {
        setHasOptionsMenu(true)
//        ed_name_change.text = mCurrentNote.name
//        ed_surname_change.text = mCurrentNote.surname
//        ed_phone_number_change.text = mCurrentNote.number
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

    override fun onContactDeleted() {
        APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_listFragment)
    }

}