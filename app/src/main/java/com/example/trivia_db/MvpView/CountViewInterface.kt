package com.example.trivia_db.MvpView

import com.example.trivia_db.Model.Count

interface CountViewInterface:BaseView {
    fun displayCount(count: Count)
    fun showProgress()
    fun hideProgress()

}