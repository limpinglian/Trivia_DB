package com.example.trivia_db.Ui

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.trivia_db.R
import com.example.trivia_db.Base.BaseActivity
import com.example.trivia_db.Model.Question
import com.example.trivia_db.MvpView.HomeViewInterface
import com.example.trivia_db.Presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*



class MainActivity : BaseActivity() {

    val mainPresenter=MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

     override fun setLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun onDetachView() {
        super.onDestroy()
        mainPresenter.unBindView()
    }


}
