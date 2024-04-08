package com.cl.daggerapp.di.app

import android.app.Application
import androidx.annotation.UiThread
import com.cl.daggerapp.Constants
import com.cl.daggerapp.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@UiThread
@Module
class AppModule(private val application: Application) {

    @Provides
    @AppScope
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun application() = application

    @AppScope
    @Provides
    fun stackoverflowApi(retrofit: Retrofit): StackoverflowApi =
        retrofit.create(StackoverflowApi::class.java)
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