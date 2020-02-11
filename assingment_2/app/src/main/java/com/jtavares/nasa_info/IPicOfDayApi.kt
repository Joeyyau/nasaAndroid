package com.jtavares.nasa_info

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IPicOfDayApi {

    @GET("planetary/apod")
    fun getPicOfDay(
        @Query("api_key") apiKey: String = "XEM0rhwKgJOa01NtUzj8mnzaHPmxkJqBLmBlA0vl"
    ) : Call<GetPicOfDayResponse>
}