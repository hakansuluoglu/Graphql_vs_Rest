package com.hakansu.restgraphql.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("/search/photos")
    fun getContents(@Query("page") page: Int, @Query("query") Query: String, @Query("client_id") client_id: String): Single<Any>

}