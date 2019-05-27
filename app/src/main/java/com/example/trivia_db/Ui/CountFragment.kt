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
import com.example.trivia_db.Model.AllCount
import com.example.trivia_db.Model.Category
import com.example.trivia_db.Model.Count
import com.example.trivia_db.Model.Question_Count
import com.example.trivia_db.MvpView.CountViewInterface
import com.example.trivia_db.Presenter.CountPresenter
import com.example.trivia_db.Presenter.MainPresenter
import com.example.trivia_db.R
import kotlinx.android.synthetic.main.item_questioncount.*
import kotlinx.android.synthetic.main.question_count.*
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList




class CountFragment : Fragment() ,CountViewInterface {

    var countPresenter = CountPresenter()
    var idArr: ArrayList<String>? = null
    var categoryArr: ArrayList<Category>? = null

    var countList: ArrayList<AllCount> = ArrayList()

    lateinit var adapter: RecyclerViewAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args=  CountFragmentArgs.fromBundle(arguments!!)
        idArr = args.category.id as ArrayList<String>
        categoryArr = args.category.triviaCategory as ArrayList<Category>


        countPresenter.bindView(this)
        return inflater.inflate(R.layout.question_count, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in idArr!!) {
            countPresenter.getCount(i)
        }
         adapter = RecyclerViewAdapter(countList, context!!, ArrayList())
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context!!, LinearLayout.VERTICAL, false)
        recycler.adapter = adapter

    }

    override fun displayCount(count: Count) {

        for (i in categoryArr!!){
            var allCount=AllCount()
            allCount.nameCategory=i.name
            allCount.countId=i.id
            countList.add(allCount)
        }

        Log.d("All Count:", countList.size.toString())

            count.category_question_count?.let {
                for( i in countList) {
                    if (count.category_id == i.countId) {
                        i.nameCategory
                        i.easy = it.easy_count
                        i.medium = it.medium_count
                        i.hard = it.hard_count
                        i.total = it.total_count
                    }
                }
            }

        adapter.notifyDataSetChanged()

    }
}





