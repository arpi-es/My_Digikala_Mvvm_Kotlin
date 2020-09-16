package com.example.mydigikala.View

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mydigikala.R
import com.example.mydigikala.Viewmodel.Viewmode_Home
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =  ViewModelProvider(this).get(Viewmode_Home::class.java)
        viewModel.getHome()
        viewModel.liveHome.observe(this, Observer {
            val adapter = AdapterViewPager(it)
             viewpager_slider.adapter = adapter
        })
        
    }
}




