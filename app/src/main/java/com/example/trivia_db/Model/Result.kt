package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
class Result {

    @JsonProperty("category")
    private var category: String? = null
    @JsonProperty("type")
    private var type: String? = null
    @JsonProperty("difficulty")
    private var difficulty: String? = null
    @JsonProperty("question")
    private var question: String? = null
    @JsonProperty("correct_answer")
    private var correctAnswer: String? = null
    @JsonProperty("incorrect_answers")
    private var incorrectAnswers: List<String>? = null

}