package com.example.trivia_db.Base

import com.example.trivia_db.MvpView.BaseView
import com.example.trivia_db.MvpView.PresenterInterface
import com.example.trivia_db.MvpView.HomeViewInterface
import com.example.trivia_db.Retrofit.RetrofitInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

open class BaseViewPresenter <T: BaseView>{
    private  var viewInterface :T?=null
    private var retrofit: Retrofit? = null

    val BASE_URL = "https://opentdb.com/"

    fun bindView(viewInterface: T) {
        this.viewInterface = viewInterface
    }

    fun getView(): T ?{
        return viewInterface
    }

    fun unBindView() {
        viewInterface=null
    }


    fun getRetrofitInstance(): RetrofitInterface {
        val client = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(loggingInterceptor)

        if (retrofit == null) {
            retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(RetrofitInterface::class.java)
    }


}
