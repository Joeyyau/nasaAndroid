package com.jtavares.nasa_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_marspics.*


const val MARS_BACKDROP = "extra_mars_backdrop"

class MarsPicsDetailsActivity : AppCompatActivity() {

    private lateinit var backdrop: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars_pics_details)

        backdrop = findViewById(R.id.mars_backdrop)


        val extras = intent.extras


        if(extras != null){
            populateDetails(extras)
        } else {
            finish()
        }
    }

    private fun populateDetails(extras: Bundle){
        extras.getString(MARS_BACKDROP)?.let { source ->
            Glide.with(this)
                .load("http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG")
                .transform(CenterCrop())
                .into(backdrop)
        }
    }
}
