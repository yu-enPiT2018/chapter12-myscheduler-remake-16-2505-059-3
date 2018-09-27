package com.example.enpit_p12.myscheduler

import android.app.Application
import io.realm.Realm

class MySchedulerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}