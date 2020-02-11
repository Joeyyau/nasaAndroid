package com.jtavares.nasa_info

import android.util.Log
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarsPicsRepository {

    private val api: IMarsPicsApi

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(IMarsPicsApi::class.java)
    }


    fun getMarsPics(
        onSuccess: (marsPics:List<MarsPics>) -> Unit,
        onError: () -> Unit

    ){
        api.getMarsPics()
            .enqueue(object: Callback<GetMarsPicsResponse> {
                override fun onResponse(
                    call: Call<GetMarsPicsResponse>,
                    response: Response<GetMarsPicsResponse>
                ){
                    if(response.isSuccessful){
                        val responseBody = response.body()

                        if(responseBody != null){
                            //Log.d("Repo", "Mars pics: ${responseBody.photos}")
                            onSuccess.invoke(responseBody.photos)
                        }else{
                            //Log.d("Repo", "Failed to get response")
                            onError.invoke()
                        }
                    } else{
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMarsPicsResponse>, t: Throwable) {
                    Log.e("Repo", "onFailure", t)
                }
            })
    }
}