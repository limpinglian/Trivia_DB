package com.example.trivia_db.Presenter

import android.util.Log
import com.example.trivia_db.Base.BasePresenter
import com.example.trivia_db.Model.Question
import com.example.trivia_db.MvpView.QuestionViewInterface
import com.example.trivia_db.MvpView.ViewInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class QuestionPresenter: BasePresenter<ViewInterface>() {

    override fun attachView(viewInterface: ViewInterface) {
        super.attachView(viewInterface)
    }

    fun onDetachView() {
        super.detachView()
    }



    }
