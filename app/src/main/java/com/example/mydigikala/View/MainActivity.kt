package com.example.mydigikala.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mydigikala.ProductPourforsh
import com.example.mydigikala.R
import com.example.mydigikala.Viewmodel.HomeViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =  ViewModelProvider(this).get(HomeViewmodel::class.java)
        viewModel.getHome()
        viewModel.liveHome.observe(this, Observer {
            val adapter = AdapterViewPager(it)
             viewpager_slider.adapter = adapter
            viewpager_slider.clipToPadding = false // fasele az bala hazf
            viewpager_slider.pageMargin = 25
            viewpager_slider.setPadding(45,0,10,0)
            viewpager_slider.currentItem = 1

            SetupRecyclerViewOffer(it.ProductPourforsh)

        })
        
    }

    fun SetupRecyclerViewOffer(lstProductPourforsh: List<ProductPourforsh>){

        recycler_off.also {
            it.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
            val adapter = AdapterRecyclerView(lstProductPourforsh)
            recycler_off.adapter = adapter

        }
    }
}




