package com.berezhnoyyuri9999.phonebook.ui.add

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.phonebook.BookApplication
import com.berezhnoyyuri9999.phonebook.MainActivityBridge
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import kotlinx.android.synthetic.main.fragment_add_person.*

class AddPersonFragment : Fragment(), AddContract.AddView {

    private lateinit var contactNavController : MainActivityBridge

    private val mPresenter by lazy {
        AddPresenter(BookApplication.getApp(context))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contactNavController = context as MainActivityBridge
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_person, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_ok.setOnClickListener {

            initialized()
        }

    }

    override fun onStart() {
        super.onStart()
        mPresenter.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        mPresenter.unBind()
    }

    @SuppressLint("CheckResult")
    private fun initialized() {
        val name = ed_name.text.toString()
        val surname = ed_surname.text.toString()
        val phoneNumber = ed_phone_number.text.toString()
        if(name.isEmpty() || surname.isEmpty() || phoneNumber.isEmpty()) {
//            showToast("Заполните все поля")
        } else {
            mPresenter.insertToDb(AppNote(name = name, surname = surname, number = phoneNumber))


        }
    }

    override fun onContactCreated() {
        contactNavController.navController().navigate(R.id.action_addPersonFragment_to_listFragment)
    }

}