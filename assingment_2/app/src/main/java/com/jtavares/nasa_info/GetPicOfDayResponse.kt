package com.jtavares.nasa_info

import com.google.gson.annotations.SerializedName

data class GetPicOfDayResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("hdurl") val pictures: List<PicOfDay>,
    @SerializedName("total_pages") val pages: Int,

    //@SerializedName("date") val date: String,
    @SerializedName("explanation") val explain: String,
    //@SerializedName("hdurl") val url: String,
    @SerializedName("title") val title: String
)
