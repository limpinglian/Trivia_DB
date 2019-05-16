package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
class Result {

    @JsonProperty("category")
    var category: String? = null
    @JsonProperty("type")
     var type: String? = null
    @JsonProperty("difficulty")
     var difficulty: String? = null
    @JsonProperty("question")
     var question: String? = null
    @JsonProperty("correct_answer")
     var correctAnswer: String? = null
    @JsonProperty("incorrect_answers")
     var incorrectAnswers: List<String>? = null

}