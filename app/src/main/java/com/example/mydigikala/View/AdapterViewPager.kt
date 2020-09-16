package com.example.mydigikala.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.mydigikala.Model.Model_Home
import com.example.mydigikala.R
import com.example.mydigikala.databinding.ItemsAdapterBinding

class AdapterViewPager(val model : Model_Home) :  PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view==`object`
    }

    override fun getCount(): Int {
        return  model.slider.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val bind:ItemsAdapterBinding = DataBindingUtil.inflate(
            LayoutInflater.from(container.context),
            R.layout.items_adapter, container, false)
        bind.image = model.slider[position].pic.replace("http://localhost", "http://192.168.0.101")
        container.addView(bind.root)
        return bind.root


    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        return container.removeView(`object` as View)
    }


    companion object{
        @JvmStatic
        @BindingAdapter("image")
        fun ImageviewPost(view: ImageView, url :String){
            Glide.with(view).load(url).into(view)
        }
    }

}