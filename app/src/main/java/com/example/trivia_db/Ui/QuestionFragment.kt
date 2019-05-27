package com.example.trivia_db.Ui

import android.graphics.Color
import android.os.Bundle
import android.support.design.card.MaterialCardView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trivia_db.R
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.text.Html
import android.util.Log
import android.util.SparseBooleanArray
import com.example.trivia_db.Model.Question
import com.example.trivia_db.Model.Result
import com.example.trivia_db.MvpView.QuestionViewInterface
import com.example.trivia_db.Presenter.QuestionPresenter
import kotlinx.android.synthetic.main.fragment_question.*
import android.view.animation.AnimationUtils
import android.widget.Toast




class QuestionFragment : Fragment(),QuestionViewInterface,View.OnClickListener {


    val BASE_URL = "https://opentdb.com/"
    var url =
        BASE_URL + "api.php?" + "amount=1" + "&token=93a6edfba47c1970df133d56d28e6ba3a48f77286e7296a002c210e68594baaa"
    var questionPresenter = QuestionPresenter()
    private val buttonMap = SparseBooleanArray()
    var correctAns:String?=null
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
        cardAnswer01.setOnClickListener(this)
        cardAnswer02.setOnClickListener(this)
        cardAnswer03.setOnClickListener(this)
        cardAnswer04.setOnClickListener(this)
        btnRoll.setOnClickListener {
            cleanUpForNextQuestion()
            questionPresenter.getQuestion(url)
        }


    }


    fun generateQuestion(questionList: List<Result>) {

        for (i in questionList) {
            tvQues_Difficulty.text = i.difficulty
            tvQuestion_question.text = i.question
            val listOfAnswer = ArrayList<Pair<String, Boolean>>()
            listOfAnswer.add(Pair(i.correctAnswer!!, true))
            i.incorrectAnswers?.forEach {
                listOfAnswer.add(Pair(it, false))
            }
            listOfAnswer.shuffle()
            cardAnswer01.setCardBackgroundColor(Color.WHITE)
            cardAnswer02.setCardBackgroundColor(Color.WHITE)
            cardAnswer03.setCardBackgroundColor(Color.WHITE)
            cardAnswer04.setCardBackgroundColor(Color.WHITE)
            cardAnswer01.visibility=View.VISIBLE
            cardAnswer02.visibility=View.VISIBLE
            cardAnswer03.visibility=View.VISIBLE
            cardAnswer04.visibility=View.VISIBLE

            text01.text=listOfAnswer[0].first
            buttonMap.put(R.id.cardAnswer01, listOfAnswer[0].second)
            text02.text=listOfAnswer[1].first
            buttonMap.put(R.id.cardAnswer02, listOfAnswer[1].second)
            text03.text=listOfAnswer[2].first
            buttonMap.put(R.id.cardAnswer03, listOfAnswer[2].second)
            text04.text=listOfAnswer[3].first
            buttonMap.put(R.id.cardAnswer04, listOfAnswer[3].second)

        }

        }
    override fun displayQuestion(question: Question) {
        buttonMap.clear()
        btnRoll.isEnabled = true
        generateQuestion(question.results)

    }

    override fun showProgress() {
        pbQuestion.visibility=View.VISIBLE
    }
    override fun hideProgress() {
        pbQuestion.visibility=View.GONE
    }

    override fun onClick(view: View?) {
        cardAnswer01.setCardBackgroundColor(Color.WHITE)
        cardAnswer02.setCardBackgroundColor(Color.WHITE)
        cardAnswer03.setCardBackgroundColor(Color.WHITE)
        cardAnswer04.setCardBackgroundColor(Color.WHITE)
        view?.let {
            val result = buttonMap.get(view.id)
            val cardView = view as CardView
            if (result) {
                cardView.setCardBackgroundColor(resources.getColor(R.color.green))
            } else {
                cardView.setCardBackgroundColor(resources.getColor(R.color.colorRed))
                cardView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake))

            }

        }

    }
    fun cleanUpForNextQuestion() {

        cardAnswer01.visibility = View.GONE
        cardAnswer02.visibility = View.GONE
        cardAnswer03.visibility = View.GONE
        cardAnswer04.visibility = View.GONE
        btnRoll.isEnabled = false
        pbQuestion.visibility = View.VISIBLE
        tvQues_Difficulty.visibility = View.GONE
        tvQuestion_question.text=""
        text01.text = ""
        text02.text = ""
        text03.text = ""
        text04.text = ""
    }
    }





