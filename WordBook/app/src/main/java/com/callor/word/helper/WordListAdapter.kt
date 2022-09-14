package com.callor.word.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.callor.word.R
import com.callor.word.model.Word

class WordListAdapter : ListAdapter<Word, WordListAdapter.WordViewHolder>() {

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        companion object {
            fun create(parent:ViewGroup) : WordViewHolder {
                val view : View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.word_item_view,parent,false)

                return WordViewHolder(view)
            }
        }
    }
}