package com.munster.swoosh.model

import android.os.Parcel
import android.os.Parcelable

class Player constructor(var league: String, var skill: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    } // This constructor reads the strings that we will be 'parceling' into our class

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(league)
        parcel.writeString(skill)
    } // Gives us the ability to write the strings to the parcel

    override fun describeContents(): Int {
        return 0
    } // this will NOT be used hence returning 0

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    } // This is required by the 'parcelable' class

}

/*
What is a 'parcelable' class?

- This is when your application expects properties of a specific type (e.g. String, Int etc.) but the data coming from your class does NOT contain any of the types you require.
- It is here where we create an INSTANCE of the 'Player' class which uses a 'Parcelable implementation generator' to create properties that we can use throughout our app.

1 - " An automatic Parcelable implementation generator. Declare the serialized properties in a primary constructor
    and add a @Parcelize annotation, and writeToParcel()/createFromParcel() methods will be created automatically "

2 - In essence, this is a way to wrap up everything inside a class and put it into a format that can be 'passed around' from 'activity to activity'. You 'serialise'
    the properties upon creation and 'de-serialise' them upon on the other side.

3 - So we have created an INSTANCE of a 'parcelable' 'Player' class, which has properties of 'league' and 'skill' inside of it.

4 - NOTE: WHEN YOU NEED TO PASS CLASSES FROM ONE ACTIVITY TO THE NEXT - USE 'PARCELABLES'. VERY 'FAST' AND RECOMMENDED WAY TO DO IT





*
*
**/