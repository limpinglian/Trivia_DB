package com.example.trivia_db.Model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Categories {
    @JsonProperty("trivia_categories")
    var triviaCategory:List<Category> ?=null
}