package com.android_wavelength.retrofit

import com.android_wavelength.retrofit.models.BookListItem
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("new")
    fun getBooks(): Call<BookListItem>
}