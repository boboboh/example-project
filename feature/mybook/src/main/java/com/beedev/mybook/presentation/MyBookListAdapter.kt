package com.beedev.mybook.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beedev.mybook.databinding.LayoutBookItemBinding
import com.beedev.mybook.domain.model.BookModel

class MyBookListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val bookList = arrayListOf<BookModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            LayoutBookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is BookItemViewHolder) {
            holder.bind(bookList[position])
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun updateBookList(list: List<BookModel>) {
        bookList.clear()
        bookList.addAll(list)
        notifyDataSetChanged()
    }
}