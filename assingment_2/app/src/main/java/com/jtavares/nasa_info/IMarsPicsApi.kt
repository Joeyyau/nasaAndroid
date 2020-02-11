package com.jtavares.nasa_info

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMarsPicsApi {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000")
    fun getMarsPics(
        @Query("api_key") apiKey: String = "XEM0rhwKgJOa01NtUzj8mnzaHPmxkJqBLmBlA0vl"

    ) : Call<GetMarsPicsResponse>
}