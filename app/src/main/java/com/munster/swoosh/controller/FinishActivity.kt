package com.munster.swoosh.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.munster.swoosh.R
import com.munster.swoosh.utilities.EXTRA_LEAGUE
import com.munster.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        searchLeaguesText.text = getString(R.string.test_message, "$league", "$skill")

    }
}