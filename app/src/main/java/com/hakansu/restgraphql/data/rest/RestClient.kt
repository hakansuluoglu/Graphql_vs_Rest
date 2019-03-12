package com.hakansu.restgraphql.data.rest

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestClient @Inject constructor() {

    @Inject lateinit var retrofit:Retrofit
    val restApi: RestApi


    init {
        restApi = retrofit.create(RestApi::class.java)
    }


}