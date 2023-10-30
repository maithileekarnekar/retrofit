package com.android_wavelength.retrofit.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Books (
    @SerializedName("title")
    var title : String? = null,
    @SerializedName("subtitle")
    var subtitle : String? = null,
    @SerializedName("isbn13")
    var isbn13 : String? = null,
    @SerializedName("price")
    var price : String? = null,
    @SerializedName("image")
    var image : String? = null,
    @SerializedName("url")
    var url : String? = null,
) : Serializable
