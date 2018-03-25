package com.munster.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.munster.swoosh.R
import com.munster.swoosh.model.Player
import com.munster.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) { // creates a new INSTANCE on startup
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player) // NULL here because of Bundle?
    } // We now can access our saved instance state

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) { // null-check
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        } // if not null then we get the parcelable and save it to 'itself'
    }


    // configuring out the buttons on the 'LeagueActivity' page
    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    // creating an intent from 'League Activity' to 'skill activity screen'
    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            // passing in an INSTANCE of the 'Player' class, which has the properties of 'league' and 'skill' inside it.
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a League", Toast.LENGTH_SHORT).show()
        }
    }
}


/*
NOTE: When you start a new activity you create a new instance of 'savedInstanceState'. However, when you rotate the screen you DESTROY that
instance.
- Hence when you start up your app you would create
    - INSTANCE 1
    - Then you rotate the screen and 'INSTANCE 1' is destroyed and you start working on 'INSTANCE 2'
- So to ensure the changes from INSTANCE 1 are saved and carried onto INSTANCE 2 we need to do the following:
    - To save the changes in the CURRENT state we use a method called: [ onSaveInstanceState(outState: Bundle?) ]
    - To restore the changes from one INSTANCE to the next: [ onRestoreInstanceState(outState: Bundle?) ]





*/