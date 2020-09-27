package com.example.mydigikala.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mydigikala.R
import com.example.mydigikala.databinding.FragmentHomeBinding
import com.example.mydigikala.model.ProductPourforsh
import com.example.mydigikala.view.adapter.AdapterRecyclerView
import com.example.mydigikala.view.adapter.AdapterViewPager
import com.example.mydigikala.viewModel.HomeViewmodel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(){


    var binding : FragmentHomeBinding?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        val viewModel =  ViewModelProvider(this).get(HomeViewmodel::class.java)
        viewModel.getHome()
        viewModel.liveHome.observe(requireActivity() , Observer {
            val adapter = AdapterViewPager(it)
            viewpager_slider.adapter = adapter
            viewpager_slider.clipToPadding = false // fasele az bala hazf
            viewpager_slider.pageMargin = 25
            viewpager_slider.setPadding(45,0,10,0)
            viewpager_slider.currentItem = 1

            SetupRecyclerViewOffer(it.ProductPourforsh)

        })


        return binding!!.root
//        return super.onCreateView(inflater, container, savedInstanceState)
    }


    fun SetupRecyclerViewOffer(lstProductPourforsh: List<ProductPourforsh>){

        recycler_off.also {
            it.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
            val adapter = AdapterRecyclerView(lstProductPourforsh)
            recycler_off.adapter = adapter

        }
    }




}