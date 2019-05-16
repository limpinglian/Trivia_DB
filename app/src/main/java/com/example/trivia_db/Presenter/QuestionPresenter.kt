
package com.example.trivia_db.Presenter

import android.util.Log
import com.example.trivia_db.Base.BaseViewPresenter
import com.example.trivia_db.Model.Question
import com.example.trivia_db.MvpView.BaseView
import com.example.trivia_db.MvpView.QuestionViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class QuestionPresenter: BaseViewPresenter<QuestionViewInterface>() {

  /*   fun attachView(questionViewInterface: QuestionViewInterface) {
        super.attachView(questionViewInterface)
    }

    fun onDetachView() {
        super.detachView()
    }*/

    fun getQuestion(url:String) {
        val service = getRetrofitInstance()
        service.getQuestion(url)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : DisposableObserver<Question>() {
                override fun onNext(question: Question) {
                    if (question != null) {
                        getView()?.showProgress()
                        getView()?.displayQuestion(question)
                        Log.d("Question:", question.toString())
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
