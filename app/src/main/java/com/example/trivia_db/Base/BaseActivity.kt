package com.example.trivia_db.Base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {
    private val mToolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResourceId())
    }
    protected abstract fun setLayoutResourceId(): Int
    @Override
    protected open fun onDetachView(){
        super.onDestroy()
    }

    /*fun getToolbar(): Toolbar?{
        return mToolbar
    }*/
}
