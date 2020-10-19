package com.example.mydigikala.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mydigikala.model.ProductPourforsh
import com.example.mydigikala.R
import com.example.mydigikala.view.adapter.AdapterRecyclerView
import com.example.mydigikala.view.adapter.AdapterViewPager
import com.example.mydigikala.viewModel.HomeViewmodel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    lateinit var navController : NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appBarConfiguration = AppBarConfiguration.Builder(R.navigation.navigations).build()

        navController = Navigation.findNavController(this, R.id.fragment)

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(BottomNavView, navController)
        BottomNavView.setOnNavigationItemSelectedListener(this)

    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null as DrawerLayout)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
         when(item.itemId){

             R.id.Menu_home ->{
                 navController.navigate(R.id.homeFragment)
             }




         }

        return true
    }


}




