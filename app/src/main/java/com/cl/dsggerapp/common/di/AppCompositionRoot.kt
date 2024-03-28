package com.cl.dsggerapp.common.di

import android.app.Application
import androidx.annotation.UiThread
import com.cl.dsggerapp.Constants
import com.cl.dsggerapp.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@UiThread
class AppCompositionRoot(val application: Application) {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val stackoverflowApi:StackoverflowApi by lazy {
        retrofit.create(StackoverflowApi::class.java)
    }
//    this same initialisation. Using backing property
//    private var _retrofit: Retrofit? = null
//    private val retrofit: Retrofit =
//        if (_retrofit == null) {
//            _retrofit = Retrofit.Builder()
//                .baseUrl(Constants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            _retrofit!!
//        } else {
//            _retrofit!!
//        }


//    private val stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

}