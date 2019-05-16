package com.example.trivia_db.Model

import android.os.Parcel
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Category()  {
    @JsonProperty("id")
    var id: String? = null
    @JsonProperty("name")
    var name:String?=null


}