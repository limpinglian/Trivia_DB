package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Count {
    @JsonProperty("category_id")
    var category_id:String?=null

    @JsonProperty("category_question_count")
    var category_question_count:Question_Count ?= null
}