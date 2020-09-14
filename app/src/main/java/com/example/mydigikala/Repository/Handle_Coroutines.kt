package com.example.mydigikala.Repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.security.auth.callback.Callback

object Handle_Coroutines {



    fun <T:Any> ThreadMain(work:suspend ( () -> T), callback: ( (T) -> Unit )) =
        CoroutineScope(Dispatchers.Main).launch {

            val data  = CoroutineScope(Dispatchers.IO).async rt@ {
               return@rt work()
            }.await()
            callback(data)
        }
}