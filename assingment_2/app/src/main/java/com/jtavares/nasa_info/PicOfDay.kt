package com.jtavares.nasa_info

import com.google.gson.annotations.SerializedName

data class PicOfDay (
    @SerializedName("date") val date: String,
    @SerializedName("explanation") val explain: String,
    @SerializedName("hdurl") val url: String,
    @SerializedName("title") val title: String
)
