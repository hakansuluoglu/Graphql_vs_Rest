package com.hakansu.restgraphql.data

import com.hakansu.restgraphql.data.model.Repo
import io.reactivex.Single
import retrofit2.http.GET

interface RestApi {

    @GET("/user/repos")
    fun getRepos(): Single<List<Repo>>

}