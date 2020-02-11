package com.jtavares.nasa_info

import android.media.Image
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.bumptech.glide.request.target.ImageViewTarget
import com.bumptech.glide.request.target.ImageViewTargetFactory

class PicOfDayAdapter (
    private var pictures: List<PicOfDay>
) : RecyclerView.Adapter<PicOfDayAdapter.PicOfDayViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): PicOfDayViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_picofday, parent, false)
        return PicOfDayViewHolder(view)
    }

    override fun getItemCount(): Int = pictures.size

    override fun onBindViewHolder(holder: PicOfDayViewHolder, position: Int) {
        holder.bind(pictures[position])
    }

    fun updatePicOfDay(pictures: List<PicOfDay>){
        this.pictures = pictures
        notifyDataSetChanged()
}

    inner class PicOfDayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val poster: ImageView = itemView.findViewById(R.id.item_pic_of_day)

        fun bind(pictures: PicOfDay){
            Glide.with(itemView)
                .load(pictures.url)
                .transform(CenterCrop())
                .into(poster)
        }

    }

}