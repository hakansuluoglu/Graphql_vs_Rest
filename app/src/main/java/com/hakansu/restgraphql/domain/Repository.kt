package com.hakansu.restgraphql.domain

import com.apollographql.apollo.api.Response
import com.hakansu.restgraphql.GitReposQuery
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {

     fun getGitRepos(naber:Int): Observable<Response<GitReposQuery.Data>>

     fun getGitRepos(): Single<List<Repository>>

}