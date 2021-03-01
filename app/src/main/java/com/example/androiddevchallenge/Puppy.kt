package com.example.androiddevchallenge

import android.os.Parcel
import android.os.Parcelable


class Puppy(
    var res: Int,
    var name: String?,
    var age: String?,
    var gender: String?,
    var desc: String?
) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(res)
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(gender)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Puppy> {
        override fun createFromParcel(parcel: Parcel): Puppy {
            return Puppy(parcel)
        }

        override fun newArray(size: Int): Array<Puppy?> {
            return arrayOfNulls(size)
        }
    }

}