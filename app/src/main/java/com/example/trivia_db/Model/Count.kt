package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Count {
    @JsonProperty("category_question_count")
    var category_question_count:List<Question_Count> ?=null
}