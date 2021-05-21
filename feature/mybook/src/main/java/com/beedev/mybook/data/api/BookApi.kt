package com.beedev.mybook.data.api

import com.beedev.mybook.domain.model.BookModel
import retrofit2.Call
import retrofit2.http.GET

interface BookApi {

    @GET("/my_book.json")
    fun getMyBook(): Call<List<BookModel>>
}