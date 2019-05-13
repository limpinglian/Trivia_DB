package com.example.trivia_db.Base

import android.app.Activity
import android.os.Bundle

abstract class BaseActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResourceId())
    }
    protected abstract fun setLayoutResourceId(): Int
    @Override
    protected open fun onDetachView(){
        super.onDestroy()
    }
}
