package com.example.mydigikala

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mydigikala.Viewmodel.Viewmode_Home


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel =  ViewModelProvider(this).get(Viewmode_Home::class.java)
        val s = viewModel.GetTest()
        Log.e("Slider", s )

        viewModel.GetHome()
        viewModel.livehome.observe(this, Observer {
            for(i in  it.slider.indices){
                Log.e("Slider", it.slider[i].name)
            }

        })
        
    }
}




