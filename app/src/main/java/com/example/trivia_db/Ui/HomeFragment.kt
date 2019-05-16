package com.example.trivia_db.Ui

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
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
import android.widget.AdapterView.OnItemSelectedListener




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment(),HomeViewInterface {

    val mainPresenter = MainPresenter()
    val arrDifficulty = arrayOf("Default", "easy", "medium", "hard")
    val arrType= arrayOf("Default","multiple","boolean")
    var categoryId:String?=null
    var difficulty:String?=null
    var type:String?=null
    val dataId = ArrayList<String>()
    private var mContext: Context? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mContext = context
    }

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
        difficulty=spDifficulty.selectedItem.toString()
        type=spType.selectedItem.toString()

        val bundle = Bundle()

         btnNext.setOnClickListener {
             bundle.putString("categoryID",categoryId.toString())
             bundle.putString("difficulty",difficulty.toString())
             bundle.putString("type",type.toString())
             view.findNavController().navigate(R.id.action_Proceed_to_questionFrag,bundle)
         }
        /*var bundleCount = Bundle().apply {
            putParcelableArrayList("LIST", List<Parcelable>(dataId))
        }*/
        tvQuestionCount.setOnClickListener {

        }
    }


    fun generateCategorySpinner(dataList: List<Category>) {

        val data = ArrayList<String>()
        data.add("Default")
        for (i in dataList) {
            i.name?.let {
                data.add(it)
            }
        }
        for (i in dataList) {
            i.id?.let {
                dataId.add(it)
                Log.d("dataId",dataId.toString()+"")
            }
        }

        val array_adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, data)
        Log.d("get categories:", data.size.toString() + "")
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCategory.adapter = array_adapter

        spCategory.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                 categoryId=dataList.get(position).id.toString()
                Log.d("get id",categoryId.toString()+"")
            }

            override fun onNothingSelected(parent: AdapterView<*>){
            }
        }
    }

    override fun displayCategory(categories: Categories) {
        if(categories!=null){
            categories.triviaCategory?.let {
                generateCategorySpinner(it)
            }
        }


    }
    fun generateDifficultySpinner(){
        val adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item,arrDifficulty)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spDifficulty.adapter = adapter

     spDifficulty.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                difficulty=arrDifficulty.get(position)

            }

            override fun onNothingSelected(parent: AdapterView<*>){
            }
        }
    }
    fun generateTypeSpinner(){
        val adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item,arrType)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spType.adapter = adapter

        spType.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                type=arrType.get(position)


            }

            override fun onNothingSelected(parent: AdapterView<*>){
            }
        }
    }
    override fun showProgress() {
        progressBar.visibility=View.VISIBLE
    }
    override fun hideProgress() {
        progressBar.visibility=View.GONE
    }





}

