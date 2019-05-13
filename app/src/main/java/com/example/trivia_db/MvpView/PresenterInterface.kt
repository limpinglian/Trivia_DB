package com.example.trivia_db.MvpView

interface PresenterInterface<V:ViewInterface>
{
    fun attachView(viewInterface:V)
    fun detachView()
}