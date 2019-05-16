package com.example.trivia_db.Ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trivia_db.R
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.trivia_db.Model.Question
import com.example.trivia_db.Model.Result
import com.example.trivia_db.MvpView.QuestionViewInterface
import com.example.trivia_db.Presenter.QuestionPresenter
import kotlinx.android.synthetic.main.fragment_question.*
import android.view.animation.AnimationUtils
import android.widget.Toast


class QuestionFragment : Fragment(),QuestionViewInterface {


    val BASE_URL = "https://opentdb.com/"
    var url =
        BASE_URL + "api.php?" + "amount=1" + "&token=9010316fb3b267b35b60ef55ae994d25d8a60d384ff38c57fde1bd4a04f7a590"
    var questionPresenter = QuestionPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val category = arguments?.getString("categoryID")
        val difficulty = arguments?.getString("difficulty")
        val type = arguments?.getString("type")
        Log.d("get All:", category.toString() + difficulty.toString() + "")

        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)



        if (category != "Default") {
            url = url + "&category=" + category
        }
        if (difficulty != "Default") {
            url = url + "&difficulty=" + difficulty
        }
        if (type != "Any") {
            url = url + "&type=" + type
        }

        questionPresenter.getQuestion(url)
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // val navController= Navigation.findNavController(view)
        // navController.navigateUp()
        questionPresenter.bindView(this)
        val shake = AnimationUtils.loadAnimation(context, R.anim.shake)
        cardAnswer01.setOnClickListener{
            Toast.makeText(context,"You are right!",Toast.LENGTH_SHORT).show();
        }
        cardAnswer02.setOnClickListener {
            cardAnswer02.animation=shake
            Toast.makeText(context,"You are wrong!",Toast.LENGTH_SHORT).show();

        }
        cardAnswer03.setOnClickListener {
            cardAnswer03.animation=shake
            Toast.makeText(context,"You are wrong!",Toast.LENGTH_SHORT).show();

        }
        cardAnswer04.setOnClickListener {
            cardAnswer04.animation=shake
            Toast.makeText(context,"You are wrong!",Toast.LENGTH_SHORT).show();

        }

        btnRoll.setOnClickListener {
            text01.text = ""
            text02.text = ""
            text03.text = ""
            text04.text = ""
            questionPresenter.getQuestion(url)
        }


    }


    fun generateQuestion(questionList: List<Result>) {
        for (i in questionList) {
            tvQues_Difficulty.text = i.difficulty
            tvQuestion_question.text = i.question
            text01.text = i.correctAnswer
            text02.text = i.incorrectAnswers!![0]
            text03.text=i.incorrectAnswers!![1]
            text04.text=i.incorrectAnswers!![2]




        }

        }
    override fun displayQuestion(question: Question) {
        generateQuestion(question.results)
    }

    override fun showProgress() {
        pbQuestion.visibility=View.VISIBLE
    }
    override fun hideProgress() {
        pbQuestion.visibility=View.GONE
    }
    }





