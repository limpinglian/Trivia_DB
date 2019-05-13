package com.example.trivia_db.MvpView

import com.example.trivia_db.Model.Categories
import com.example.trivia_db.Model.Question

interface ViewInterface {
    fun displayCategory(categories: Categories)
    fun showProgress()
    fun hideProgress()
    fun displayQuestion(question: Question)

}