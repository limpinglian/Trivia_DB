package com.example.trivia_db.Ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import com.example.trivia_db.Model.Categories
import com.example.trivia_db.Model.Category
import com.example.trivia_db.MvpView.HomeViewInterface
import com.example.trivia_db.Presenter.MainPresenter
import com.example.trivia_db.R
import kotlinx.android.synthetic.main.fragment_home.*
import android.widget.AdapterView
import android.widget.Toast


class HomeFragment : Fragment(), HomeViewInterface {

    val mainPresenter = MainPresenter()
    var categoryId: String? = null
    var difficulty: String? = null
    var type: String? = null
    val dataId = ArrayList<String>()
    val dataName = ArrayList<String>()
    var bundleCount = Bundle()
    val CountArr = ArrayList<String>()

    private var mContext: Context? = null

    private var categories: Categories? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val context = this.mContext
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainPresenter.bindView(this)
        mainPresenter.getCategories()
        generateDifficultySpinner()
        generateTypeSpinner()

        val bundle = Bundle()
        btnNext.setOnClickListener {
            bundle.putString("categoryID", categoryId.toString())
            bundle.putString("difficulty", difficulty.toString())
            bundle.putString("type", type.toString())
            view.findNavController().navigate(R.id.action_Proceed_to_questionFrag, bundle)
        }
        bundleCount.putStringArrayList("id", dataId)
        bundleCount.putStringArrayList("categoryName", dataName)

        tvQuestionCount.setOnClickListener {
            categories?.id = dataId
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCountFragment(categories!!))
        }
    }


    fun generateCategorySpinner(dataList: List<Category>) {


        dataName.add("Default")
        for (i in dataList) {
            i.name?.let {
                dataName.add(it)
            }
            i.id?.let {
                dataId.add(it)
            }
        }


        val array_adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, dataName)
        Log.d("get categories:", dataName.toString() + "")
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCategory.adapter = array_adapter

        spCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                categoryId = dataList.get(position).id.toString()
                Log.d("get id", categoryId.toString() + "")
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

    override fun displayCategory(categories: Categories) {

        if (categories != null) {
            this.categories = categories
            categories.triviaCategory?.let {
                generateCategorySpinner(it)
            }
        }

    }

    fun generateDifficultySpinner() {
        val adapter = ArrayAdapter.createFromResource(context!!,R.array.arrDifficulty, android.R.layout.simple_spinner_item )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spDifficulty.adapter = adapter

        spDifficulty.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (position != null) {
                    difficulty = parent.getItemAtPosition(position).toString()
                } else {
                    Toast.makeText(getActivity(), "Please select item", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

    fun generateTypeSpinner() {
        val adapter = ArrayAdapter.createFromResource(context!!,R.array.arrType, android.R.layout.simple_spinner_item )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spType.adapter = adapter

        spType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                type=parent.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }


}

