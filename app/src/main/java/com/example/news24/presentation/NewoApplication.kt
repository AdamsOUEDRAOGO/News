package com.example.news24.presentation

import android.app.Application

class NewoApplication: Application(){
    companion object{
        var context: Context? = null
    }
    override fun onCreate(){
        super.onCreate()
        context = this
    }
}