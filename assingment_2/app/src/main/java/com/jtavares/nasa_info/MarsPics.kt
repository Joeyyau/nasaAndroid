package com.jtavares.nasa_info

import com.google.gson.annotations.SerializedName

data class MarsPics (
    @SerializedName("id") val id: Int,
    @SerializedName("img_src") val source: String,
    @SerializedName("earth_date") val date: String,
    @SerializedName("name") val roverName : String

    )