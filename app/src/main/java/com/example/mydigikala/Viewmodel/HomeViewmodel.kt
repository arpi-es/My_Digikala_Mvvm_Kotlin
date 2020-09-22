package com.example.mydigikala.Viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydigikala.HomeModel
import com.example.mydigikala.Repository.Api
import com.example.mydigikala.Repository.Handle_Coroutines
import com.example.mydigikala.Repository.Handle_Request
import kotlinx.coroutines.Job

class HomeViewmodel : ViewModel() {

     val liveHome = MutableLiveData<HomeModel>()
    private lateinit var job : Job


    // geteftane data home. aval api ro call mikonim, chon invoke e khode api ro barmigardune,
    // in api ro midim be Handle_Request -> ya body ro migim ya exeption
    //  in body va callbacko midim be Handle_Coroutines , karasho anjam mide tu thread natijaro mirize to it,
    //it ro mirizim ti livedatamun ke az tu main ghabele dastresi bashe

    fun getHome(){
     job = Handle_Coroutines.ThreadMain(
         {
             Handle_Request.Request(Api.invoke().getHomeResponse())
         }
         ,
         {
             Log.i("MYTAG", it.toString())
             liveHome.value = it

         }
     )
    }

    override fun onCleared() {
        if(::job.isInitialized)job.cancel()
        super.onCleared()
    }
}