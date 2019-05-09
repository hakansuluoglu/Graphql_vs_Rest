package com.hakansu.restgraphql.data.model

import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("node_id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("avatar_url")
    var avatarUrl: String? = null
}