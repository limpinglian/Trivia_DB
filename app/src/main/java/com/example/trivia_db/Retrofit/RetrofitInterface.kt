package com.example.trivia_db.Retrofit

import com.example.trivia_db.Model.Categories
import com.example.trivia_db.Model.Category
import com.example.trivia_db.Model.Question
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

interface RetrofitInterface {
    @GET("api_category.php?&token=e5013da6222668c0d2cb4eba0eeaf1d787407f2b888408ea68e06b3e97994a44")
    fun getResponse():Observable<Categories>

    @POST("https://opentdb.com/api.php?amount=1&token=e5013da6222668c0d2cb4eba0eeaf1d787407f2b888408ea68e06b3e97994a44")
    fun getQuestion(@Query("categories")categories:String,@Query("difficulty")difficulty:String,@Query("type")type:String):Observable<Question>
}