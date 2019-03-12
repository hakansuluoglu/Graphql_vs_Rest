package com.hakansu.restgraphql.domain.model

import com.google.gson.annotations.SerializedName

class Repository {


    @SerializedName("description")
    var description: String? = null

    @SerializedName("name")
    var name: String? = null
}