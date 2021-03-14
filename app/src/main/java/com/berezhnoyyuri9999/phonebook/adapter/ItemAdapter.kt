package com.berezhnoyyuri9999.phonebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.data.models.AppNote

class ItemAdapter(var clickListener: (Int, AppNote) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var mListNotes: List<AppNote> = ArrayList()

    fun setData(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mListNotes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val positionList = mListNotes[position]

        holder.nameNote.text = positionList.name
        holder.surnameNote.text = positionList.surname
        holder.numberNote.text = positionList.number

        holder.itemView.setOnClickListener {
            clickListener.invoke(holder.adapterPosition, mListNotes[holder.adapterPosition])
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameNote: TextView
        var surnameNote: TextView
        var numberNote: TextView

        init {
            nameNote = itemView.findViewById(R.id.userName)
            surnameNote = itemView.findViewById(R.id.userSurname)
            numberNote = itemView.findViewById(R.id.userNumber)
        }

    }
}
