package dev.hmyh.easymobile.data.models

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import dev.hmyh.easymobile.BuildConfig
import dev.hmyh.easymobile.network.EasyMobileApi
import dev.hmyh.easymobile.persistence.EasyMobileDatabase
import dev.hmyh.easymobile.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Time
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    lateinit var easyMobileApi: EasyMobileApi

    fun init(context: Context){
        initNetwork(context)
        initDatabase(context)
    }

    private fun initNetwork(context: Context) {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG)addInterceptor(ChuckInterceptor(context))
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        easyMobileApi = retrofit.create(EasyMobileApi::class.java)
    }

    protected lateinit var database: EasyMobileDatabase

    private fun initDatabase(context: Context) {
        database = EasyMobileDatabase.getInstance(context)
    }
}