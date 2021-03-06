package com.example.trivia_db.Presenter

import android.util.Log
import com.example.trivia_db.Base.BaseViewPresenter
import com.example.trivia_db.Model.Categories
import com.example.trivia_db.Model.Count
import com.example.trivia_db.MvpView.HomeViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainPresenter : BaseViewPresenter<HomeViewInterface>() {

    /*override fun attachView(homeViewInterface: HomeViewInterface) {
        super.attachView(homeViewInterface)
    }

    fun onDetachView() {
        super.detachView()
    }*/

    fun getCategories() {
        val service = getRetrofitInstance()
        service.getResponse()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<Categories>() {
                override fun onNext(categories: Categories) {
                    if (categories != null) {
                        getView()?.showProgress()
                        getView()?.displayCategory(categories)
                        Log.d("Successful","" )
                    } else {
                        Log.d("error", "is null")
                    }
                }

                override fun onError(t: Throwable) {

                }

                override fun onComplete() {
                    getView()?.hideProgress()
                }
            })
    }

}


