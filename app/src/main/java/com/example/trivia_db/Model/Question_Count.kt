package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Question_Count {
    @JsonProperty("total_question_count")
    var total_count:String?=null
    @JsonProperty("total_easy_question_count")
    var easy_count:String?=null
    @JsonProperty("total_medium_question_count")
    var medium_count:String?=null
    @JsonProperty("total_hard_question_count")
    var hard_count:String?=null

    var categoryName : String ?= null

}