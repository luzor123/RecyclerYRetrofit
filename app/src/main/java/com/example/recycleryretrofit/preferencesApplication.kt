package com.example.recycleryretrofit

import android.app.Application

class preferencesApplication:Application() {
    companion object{
        lateinit var prefe: prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefe= prefs(applicationContext)
    }
}