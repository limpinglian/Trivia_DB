package com.example.trivia_db.Ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.trivia_db.Adapter.RecyclerViewAdapter
import com.example.trivia_db.Model.Count
import com.example.trivia_db.Model.Question_Count
import com.example.trivia_db.MvpView.CountViewInterface
import com.example.trivia_db.Presenter.CountPresenter
import com.example.trivia_db.R
import kotlinx.android.synthetic.main.question_count.*


class CountFragment : Fragment() ,CountViewInterface{

var countPresenter=CountPresenter()
    var idArr:ArrayList<String>?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         idArr= arguments!!.getStringArrayList("id")
        Log.d("All Count:",idArr.toString())

        return inflater.inflate(R.layout.question_count, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countPresenter.bindView(this)
        for (i in idArr!!) {
            countPresenter.getCount(i)
        }
    }

    fun generateRecyclerView(dataList: List<Question_Count>){

        val adapter = RecyclerViewAdapter(dataList,context!!)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context!!, LinearLayout.VERTICAL, false)
        recycler.adapter = adapter
        Log.d("datalist", dataList.size.toString() + "")
    }
    override fun displayCount(count: Count) {
        count.category_question_count?.let {
            generateRecyclerView(it)}

        Log.d("Display",count.category_question_count!!.toString()+"")

    }

}





