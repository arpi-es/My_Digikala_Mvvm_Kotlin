package com.example.mydigikala.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydigikala.model.HomeModel
import com.example.mydigikala.repository.Api
import com.example.mydigikala.repository.HandleCoroutines
import com.example.mydigikala.repository.HandleRequest
import kotlinx.coroutines.Job

class HomeViewmodel : ViewModel() {

     val liveHome = MutableLiveData<HomeModel>()
    private lateinit var job : Job


    // geteftane data home. aval api ro call mikonim, chon invoke e khode api ro barmigardune,
    // in api ro midim be Handle_Request -> ya body ro migim ya exeption
    //  in body va callbacko midim be Handle_Coroutines , karasho anjam mide tu thread natijaro mirize to it,
    //it ro mirizim ti livedatamun ke az tu main ghabele dastresi bashe

    fun getHome(){
     job = HandleCoroutines.ThreadMain(
         {
             HandleRequest.Request(Api.invoke().getHomeResponse())
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