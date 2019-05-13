package com.example.trivia_db.Ui

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import android.view.View
import com.example.trivia_db.R
import android.widget.ArrayAdapter
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.trivia_db.Base.BaseActivity
import com.example.trivia_db.Model.Categories
import com.example.trivia_db.Model.Category
import com.example.trivia_db.Model.Question
import com.example.trivia_db.Model.Result
import com.example.trivia_db.MvpView.ViewInterface
import com.example.trivia_db.Presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*







const val Category="Category"
const val Difficulty="Difficulty"
const val Type="Type"
class MainActivity : BaseActivity(), ViewInterface {

    val mainPresenter = MainPresenter()
    val arrDifficulty = arrayOf("Default", "Easy", "Medium", "Hard")
    val arrType= arrayOf("Default","Multiple","Boolean")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.attachView(this)
        mainPresenter.getCategories()
        generateDifficultySpinner()
        generateTypeSpinner()
       // val fm = fragmentManager
      //  val transaction = fm.beginTransaction()
       // transaction.add(R.id.framehome, HomeFragment())
       // transaction.commit()




    }

    protected override fun setLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    fun generateCategorySpinner(dataList: List<Category>) {

        val data = ArrayList<String>()
        for (i in dataList) {
            i.name?.let {
                data.add(it)
            }
        }
        val array_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        Log.d("get categories:", data.size.toString() + "")
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCategory.adapter = array_adapter
    }

    override fun displayCategory(categories: Categories) {
        if(categories!=null){
            categories.triviaCategory?.let {
                generateCategorySpinner(it)
            }
        }


    }
    fun generateDifficultySpinner(){
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,arrDifficulty)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spDifficulty.adapter = adapter
    }
    fun generateTypeSpinner(){
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,arrType)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spType.adapter = adapter
    }

    override fun showProgress() {
        progressBar.visibility=View.VISIBLE
    }
    override fun hideProgress() {
        progressBar.visibility=View.GONE

    }

    override fun onDetachView() {
        super.onDestroy()
        mainPresenter.onDetachView()
    }
    override fun displayQuestion(question: Question) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
