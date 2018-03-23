package com.munster.swoosh.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class BaseActivity : AppCompatActivity() {

    val TAG = "LifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "${javaClass.simpleName} [ ON CREATE ]" )
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "${javaClass.simpleName} [ ON START ]" )
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "${javaClass.simpleName} [ ON RESUME ]" )
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "${javaClass.simpleName} [ ON PAUSE ]" )
        super.onPause()
    }

    override fun onRestart() {
        Log.d(TAG, "${javaClass.simpleName} [ ON RESTART ]" )
        super.onRestart()
    }

    override fun onStop() {
        Log.d(TAG, "${javaClass.simpleName} [ ON STOP ]" )
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "${javaClass.simpleName} [ ON DESTROY ]" )
        super.onDestroy()
    }
}
