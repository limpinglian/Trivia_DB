package com.example.trivia_db.Model

import android.os.Parcel
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Categories() : Parcelable{
    @JsonProperty("trivia_categories")
    var triviaCategory:List<Category> ?=null

    var id: List<String> = ArrayList()

    constructor(parcel: Parcel) : this() {
        triviaCategory = parcel.createTypedArrayList(Category)
        id = parcel.createStringArrayList()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(triviaCategory)
        parcel.writeStringList(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Categories> {
        override fun createFromParcel(parcel: Parcel): Categories {
            return Categories(parcel)
        }

        override fun newArray(size: Int): Array<Categories?> {
            return arrayOfNulls(size)
        }
    }


}