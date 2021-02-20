package com.berezhnoyyuri9999.phonebook.ui.start

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.utils.TYPE_ROOM
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment(), StartContract.StartView {



    private val mPresenter by lazy {
        context?.let { StartPresenter(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_start, container, false)

    }

    override fun onStart() {
        super.onStart()

        mPresenter?.bindView(this)
        initializeDatabase()
    }

    override fun onStop() {
        super.onStop()
        mPresenter?.unBind()
    }

    private fun initializeDatabase() {
        clickRoom.setOnClickListener {
            Single.just(TYPE_ROOM)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mPresenter?.initDatabase(TYPE_ROOM) {
                        mPresenter?.clickBook()
                        Log.e("L", it)
                    }
                }, {
                    Log.e("L", "${it.message}")
                })

        }

    }

}