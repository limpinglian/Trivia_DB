package com.example.trivia_db.Retrofit

import com.example.trivia_db.Model.Categories
import com.example.trivia_db.Model.Category
import com.example.trivia_db.Model.Count
import com.example.trivia_db.Model.Question
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url
import java.util.*

interface RetrofitInterface {
    @GET("api_category.php?token=b2f462e54c5789a668e0f55dddb12ad86c7f4c11935997d3a44718d8de7f90fd/")
    fun getResponse():Observable<Categories>

    @GET
    fun getQuestion(@Url url:String):Observable<Question>

    @GET("api_count.php?")
    fun getQuestionCount(@Query("category")categoryId:String):Observable<Count>
}