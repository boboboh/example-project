package com.beedev.mybook.presentation

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.beedev.mybook.databinding.LayoutBookItemBinding
import com.beedev.mybook.domain.model.BookModel
import com.bumptech.glide.Glide

class BookItemViewHolder(private val binding: LayoutBookItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(data: BookModel) {
        binding.apply {
            bookTitleTextView.text = data.title
            bookPriceTextView.text = "Price: ${data.price}"
            Glide.with(root.context)
                .load(data.image)
                .into(bookImageView)
        }
    }
}