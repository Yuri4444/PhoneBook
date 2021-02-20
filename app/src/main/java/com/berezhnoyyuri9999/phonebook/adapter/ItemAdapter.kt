package com.berezhnoyyuri9999.phonebook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.data.models.AppNote

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private var mListNotes : List<AppNote> = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameNote: TextView = itemView.findViewById(R.id.userName)
        val surnameNote: TextView = itemView.findViewById(R.id.userSurname)
        val numberNote: TextView = itemView.findViewById(R.id.userNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val positionList = mListNotes[position]
        holder.nameNote.text = positionList.name
        holder.surnameNote.text = positionList.surname
        holder.numberNote.text = positionList.number
    }

    override fun getItemCount() = mListNotes.size

    fun setData(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }

}