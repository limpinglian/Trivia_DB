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

    @GET("api_category.php?")
    fun getResponse():Observable<Categories>

    @GET
    fun getQuestion(@Url url:String):Observable<Question>

    @GET("api_count.php?")
    fun getQuestionCount(@Query("category")categoryId:String):Observable<Count>
}