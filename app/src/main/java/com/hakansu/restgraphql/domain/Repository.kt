package com.hakansu.restgraphql.domain

import com.apollographql.apollo.api.Response
import com.hakansu.restgraphql.GitReposQuery
import io.reactivex.Observable

interface Repository {

     fun getGitRepos(naber:Int): Observable<Response<GitReposQuery.Data>>

}