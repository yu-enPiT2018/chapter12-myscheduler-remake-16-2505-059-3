package com.example.enpit_p12.myscheduler

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.enpit_p12.myscheduler.R.id.*
import io.realm.Realm
import io.realm.kotlin.where

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        realm = Realm.getDefaultInstance()
        val schedules = realm.where<Schedule>().findAll()
        listView.adapter = ScheduleAdapter(schedules)

        fab.setOnClickListener { view ->
            startActivity<ScheduleEditActivity>()
        }
        listView.setOnItemClickListener { parent, view, position, id ->
            val schedule = parent.getItemAtPosition(position) as Schedule
            startActivity<ScheduleEditActivity>(
                    "schedule_id" to schedule.id)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
