package com.example.trivia_db.MvpView

import com.example.trivia_db.Model.Categories

interface HomeViewInterface: com.example.trivia_db.MvpView.BaseView {
    fun displayCategory(categories: Categories)
    fun showProgress()
    fun hideProgress()

}