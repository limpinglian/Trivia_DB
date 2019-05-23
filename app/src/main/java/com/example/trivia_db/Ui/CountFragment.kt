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
import com.example.trivia_db.Model.Category
import com.example.trivia_db.Model.Count
import com.example.trivia_db.Model.Question_Count
import com.example.trivia_db.MvpView.CountViewInterface
import com.example.trivia_db.Presenter.CountPresenter
import com.example.trivia_db.Presenter.MainPresenter
import com.example.trivia_db.R
import kotlinx.android.synthetic.main.item_questioncount.*
import kotlinx.android.synthetic.main.question_count.*








class CountFragment : Fragment() ,CountViewInterface {

    var countPresenter = CountPresenter()
    var idArr: ArrayList<String>? = null
    var categoryArr: ArrayList<Category>? = null
    lateinit var adapter: RecyclerViewAdapter
    private val mergeResult = ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args=  CountFragmentArgs.fromBundle(arguments!!)
        idArr = args.category.id as ArrayList<String>
        categoryArr = args.category.triviaCategory as ArrayList<Category>
     /*   val set = LinkedHashSet(categoryArr)
        set.addAll(listTwo)*/
      //  val combinedList = ArrayList(set)

        Log.d("All Count:", categoryArr.toString())
        countPresenter.bindView(this)
        return inflater.inflate(R.layout.question_count, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecyclerViewAdapter(ArrayList(), context!!)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context!!, LinearLayout.VERTICAL, false)
        recycler.adapter = adapter

        for (i in idArr!!) {
            countPresenter.getCount(i)
        }

    }

    override fun displayCount(count: Count) {
       count.category_question_count?.let {
            adapter.countList.add(it)
           adapter.notifyDataSetChanged()
        }

    }
}





