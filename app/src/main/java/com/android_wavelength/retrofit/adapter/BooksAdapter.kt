package com.android_wavelength.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android_wavelength.retrofit.R
import com.android_wavelength.retrofit.databinding.BookViewBinding
import com.android_wavelength.retrofit.models.Books
import com.bumptech.glide.Glide

class BooksAdapter (
    private val books : ArrayList<Books>
) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding : BookViewBinding
        val imgBook : ImageView

        init {
            binding = BookViewBinding.bind(view)
            imgBook = binding.imgBook
        }
    }

    override fun getItemCount() = books.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.book_view, null)
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book:Books = books[position]

        holder.binding.txtBookTitle.text = book.title

        Glide.with(holder.imgBook)
            .load(book.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imgBook)
    }

}