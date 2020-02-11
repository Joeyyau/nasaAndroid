package com.jtavares.nasa_info

import com.google.gson.annotations.SerializedName

data class GetMarsPicsResponse (

    @SerializedName("photos") val photos: List<MarsPics>,
    @SerializedName("page") val page: Int

    )
