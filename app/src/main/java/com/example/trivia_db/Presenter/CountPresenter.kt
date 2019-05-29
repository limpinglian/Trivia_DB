package com.example.trivia_db.Presenter

import android.util.Log
import com.example.trivia_db.Base.BaseViewPresenter
import com.example.trivia_db.Model.Count
import com.example.trivia_db.MvpView.CountViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CountPresenter: BaseViewPresenter<CountViewInterface>() {

    fun getCount(id:String) {
        val service = getRetrofitInstance()
        service.getQuestionCount(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<Count>() {
                override fun onNext(count: Count) {
                    if (count != null) {
                        getView()?.showProgress()
                        getView()?.displayCount(count)
                        Log.d("Successful","${count.category_id}" )
                    } else {
                        Log.d("error", "is null")
                    }
                }

                override fun onError(t: Throwable) {
                    t.printStackTrace()
                }

                override fun onComplete() {
                    getView()?.hideProgress()
                }
            })
    }
}
