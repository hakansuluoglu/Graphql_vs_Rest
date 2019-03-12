package com.hakansu.restgraphql.data.rest

import com.hakansu.restgraphql.domain.Repository
import io.reactivex.Single
import retrofit2.http.GET

interface RestApi {

    @GET("/user/repos")
    fun getRepos(): Single<List<Repository>>

}