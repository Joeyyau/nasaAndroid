package com.jtavares.nasa_info

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PicOfDayRepository {

    private val api: IPicOfDayApi

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(IPicOfDayApi::class.java)
    }

    fun getPicOfDay(
        onSuccess: (picture: List<PicOfDay>) -> Unit,
        onError: () -> Unit
    ){
        api.getPicOfDay()
            .enqueue(object: Callback<GetPicOfDayResponse>{
                override fun onResponse(
                    call: Call<GetPicOfDayResponse>,
                    response: Response<GetPicOfDayResponse>
                ) {
                    if(response.isSuccessful){
                        val responseBody = response.body()

                        if(responseBody != null){
                            Log.d("Repo", "Pic of day: ${responseBody.pictures}")
                            Log.d("Repo", "Pic of day: ${responseBody.explain}")
                            onSuccess.invoke(responseBody.pictures)
                        } else{
                            Log.d("Repo", "Failed to get response")
                            onError.invoke()

                        }
                    } else{
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetPicOfDayResponse>, t: Throwable) {
                    Log.e("Repo", "onFailure", t)
                }
            })
    }


}