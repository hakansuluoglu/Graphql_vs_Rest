package com.hakansu.restgraphql.data.model

import com.google.gson.annotations.SerializedName

class Repo {

    @SerializedName("description")
    var description: String? = null

    @SerializedName("name")
    var name: String? = null
}