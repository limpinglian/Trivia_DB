package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Question {
    @JsonProperty("results")
    var results: List<Result> = ArrayList()
    @JsonProperty("category")
    var category: List<Category> =ArrayList()
    @JsonProperty("response_code")
    private var responseCode: Int? = null
    @JsonProperty("response")
    var response: String? = null

}