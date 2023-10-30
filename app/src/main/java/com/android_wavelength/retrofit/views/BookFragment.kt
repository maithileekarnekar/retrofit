package com.android_wavelength.retrofit.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android_wavelength.retrofit.APIClient
import com.android_wavelength.retrofit.adapter.BooksAdapter
import com.android_wavelength.retrofit.databinding.BookFragmentBinding
import com.android_wavelength.retrofit.models.BookListItem
import com.android_wavelength.retrofit.models.Books
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class BookFragment : Fragment() {
    private lateinit var binding : BookFragmentBinding
    private lateinit var booksAdapter : BooksAdapter
    private var books: ArrayList<Books> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BookFragmentBinding.inflate(layoutInflater)

        initRecyclerViewAndAdapter()
        getBooks()

        return binding.root
    }

    private fun getBooks() {
        val call: Call<BookListItem> = APIClient.apiService.getBooks()

        call.enqueue(object : Callback<BookListItem> {
            override fun onResponse(call: Call<BookListItem>, response: Response<BookListItem>) {
                if (response.isSuccessful) {
                    val booksList:List<Books> = response.body()?.books ?: emptyList()
                    books.clear()
                    books.addAll(booksList)
                    booksAdapter.notifyDataSetChanged()
                } else {
                    Log.e("BookFragment", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<BookListItem>, t: Throwable) {
                Log.e("BookFragment", "Error: ${t.message}")
            }
        })
    }
    private fun initRecyclerViewAndAdapter() {
        booksAdapter = BooksAdapter(books)
        binding.recyclerBooks.adapter = booksAdapter
    }
}