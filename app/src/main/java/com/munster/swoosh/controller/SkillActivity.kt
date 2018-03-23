package com.munster.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.munster.swoosh.R
import com.munster.swoosh.model.Player
import com.munster.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player // means to initialise a var LATER....

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER) // NOTE: (var gets initialised) and we retrieve the parcelable EXTRA value

        beginnerSkillBtn.setOnClickListener {
            ballerSkillBtn.isChecked = false
            player.skill = "beginner"
        }

        ballerSkillBtn.setOnClickListener {
            beginnerSkillBtn.isChecked = false
            player.skill = "baller"
        }

        skillFinishBtn.setOnClickListener {
            if (player.skill != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_PLAYER, player) // amended to include parcelable class values
                startActivity(finishActivity)
            } else {
                Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    } // saving changes from instance 1

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }// restoring changes into instance 2

}

/*  NOTE: Trying to place the function name in the xml does not work here (reason unknown)
    - Hence had to create some 'ClickListeners' as shown above - these worked )

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }



    fun onSkillFinishClicked(view: View) {
        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }*/

