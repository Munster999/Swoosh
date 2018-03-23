package com.munster.swoosh.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.munster.swoosh.R
import com.munster.swoosh.model.Player
import com.munster.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeaguesText.text = getString(R.string.test_message, "${player.league}", "${player.skill}")

    }
}