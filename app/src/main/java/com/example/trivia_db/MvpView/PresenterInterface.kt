package com.example.trivia_db.MvpView

interface PresenterInterface<V:BaseView>
{
    fun attachView(viewInterface:V)
    fun detachView()
}