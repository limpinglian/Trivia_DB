package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Category {
    @JsonProperty("id")
    var id: Int? = null
    @JsonProperty("name")
    var name:String?=null

}