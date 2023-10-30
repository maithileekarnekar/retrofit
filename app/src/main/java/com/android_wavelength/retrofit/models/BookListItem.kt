package com.android_wavelength.retrofit.models

import com.google.gson.annotations.SerializedName

data class BookListItem(
    @SerializedName("error" )
    var error : String?= null,
    @SerializedName("total" )
    var total : String?= null,
    @SerializedName("books" )
    var books : ArrayList<Books> = arrayListOf()
)
