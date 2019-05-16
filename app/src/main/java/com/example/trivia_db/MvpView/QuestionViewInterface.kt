package com.example.trivia_db.MvpView

import com.example.trivia_db.Model.Question

interface QuestionViewInterface:com.example.trivia_db.MvpView.BaseView {
    fun displayQuestion(question: Question)
    fun showProgress()
    fun hideProgress()

}