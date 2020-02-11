package com.jtavares.nasa_info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var marsPictures: RecyclerView
    private lateinit var marsPicturesAdapter: MarsPicsAdapter

    private lateinit var pictureOfDay: RecyclerView
    private lateinit var pictureOfDayAdapter: PicOfDayAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //SET UP FOR PIC OF DAY ADAPTER
        pictureOfDay = findViewById(R.id.pic_of_day)
        pictureOfDay.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        pictureOfDayAdapter = PicOfDayAdapter(listOf())
        pictureOfDay.adapter = pictureOfDayAdapter

        PicOfDayRepository.getPicOfDay(
            onSuccess = ::onPicOfDayFetched,
            onError = ::onError
        )

        //SET UP FOR MARS PICTURES ADAPTER//
        marsPictures = findViewById(R.id.mars_pics)
        marsPictures.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        //marsPicturesAdapter = MarsPicsAdapter(listOf())
        marsPicturesAdapter = MarsPicsAdapter(mutableListOf()) { pictures -> showMarsPicsDetails(pictures)}
        marsPictures.adapter = marsPicturesAdapter

        MarsPicsRepository.getMarsPics(
            onSuccess = ::onMarsPicturesFetched,
            onError = ::onError
        )

    }

    private fun showMarsPicsDetails(pictures: MarsPics){
        val intent = Intent(this, MarsPicsDetailsActivity::class.java)
        intent.putExtra(MARS_BACKDROP, pictures.source)
        startActivity(intent)
    }

    private fun onPicOfDayFetched(picture: List<PicOfDay>){
        Log.d("Main activity", "Picture: $picture")
        pictureOfDayAdapter.updatePicOfDay(picture)

    }

    private fun onMarsPicturesFetched(marsPics:List<MarsPics>){
        //Log.d("Main activity", "Mars pics: $marsPics")
        marsPicturesAdapter.updateMarsPics(marsPics)
    }

    private fun onError(){
        Toast.makeText(this, getString(R.string.error_fetch_mars), Toast.LENGTH_SHORT).show()
    }
}
