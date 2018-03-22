package com.munster.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.munster.swoosh.R
import com.munster.swoosh.utilities.EXTRA_SKILL
import com.munster.swoosh.utilities.EXTRA_LEAGUE
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)

        beginnerSkillBtn.setOnClickListener {
            ballerSkillBtn.isChecked = false
            skill = "beginner"
        }

        ballerSkillBtn.setOnClickListener {
            beginnerSkillBtn.isChecked = false
            skill = "baller"
        }

        skillFinishBtn.setOnClickListener {
            if (skill != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_LEAGUE, league)
                finishActivity.putExtra(EXTRA_SKILL, skill)
                startActivity(finishActivity)
            } else {
                Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
            }
        }
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
}
