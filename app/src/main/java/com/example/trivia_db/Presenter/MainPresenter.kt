package com.example.trivia_db.Presenter

import android.util.Log
import com.example.trivia_db.Base.BasePresenter
import com.example.trivia_db.Model.Categories
import com.example.trivia_db.Model.Question
import com.example.trivia_db.MvpView.ViewInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainPresenter : BasePresenter<ViewInterface>() {

    override fun attachView(viewInterface: ViewInterface) {
        super.attachView(viewInterface)
    }

    fun onDetachView() {
        super.detachView()
    }

    fun getCategories() {
        val service = getRetrofitInstance()
        service.getResponse()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<Categories>() {
                override fun onNext(categories: Categories) {
                    if (categories != null) {
                        getMvpView()!!.showProgress()
                        getMvpView()!!.displayCategory(categories)
                        Log.d("Successful","" )
                    } else {
                        Log.d("error", "is null")
                    }
                }

                override fun onError(t: Throwable) {

                }

                override fun onComplete() {
                    getMvpView()!!.hideProgress()
                }
            })
    }
    fun getQuestion(category:String,difficulty:String,type:String) {
        val service = getRetrofitInstance()
        service.getQuestion(category,difficulty,type)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<Question>() {
                override fun onNext(question: Question) {
                    if (question != null) {
                        getMvpView()!!.displayQuestion(question)
                    } else {
                        Log.d("error", "is null")
                    }
                }

                override fun onError(t: Throwable) {

                }

                override fun onComplete() {
                }
            })


}}


