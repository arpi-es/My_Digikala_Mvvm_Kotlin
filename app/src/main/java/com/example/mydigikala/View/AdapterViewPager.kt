package com.example.mydigikala.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.mydigikala.HomeModel
import com.example.mydigikala.R
import com.example.mydigikala.Repository.Api
import com.example.mydigikala.databinding.ItemsAdapterBinding

class AdapterViewPager(val model : HomeModel) :  PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view==`object`
    }

    override fun getCount(): Int {
        return  model.Slider.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val bind:ItemsAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(container.context),
            R.layout.items_adapter, container, false)
        bind.image = model.Slider[position].pic.replace("http://localhost", Api.myIP)
        container.addView(bind.root)
        return bind.root

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        return container.removeView(`object` as View)
    }


    override fun getPageWidth(position: Int): Float {
       // return super.getPageWidth(position) // 1
        return 0.96f
    }

    companion object{
        @JvmStatic
        @BindingAdapter("image")
        fun ImageviewPost(view: ImageView, url :String){
            Glide.with(view).load(url).into(view)
        }
    }

}