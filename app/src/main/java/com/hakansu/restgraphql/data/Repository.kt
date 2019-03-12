package com.hakansu.restgraphql.data

import com.apollographql.apollo.api.Response
import com.hakansu.restgraphql.GitReposQuery
import com.hakansu.restgraphql.data.model.Repo
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {

     fun getGitRepos(naber:Int): Observable<Response<GitReposQuery.Data>>

     fun getGitRepos(): Single<List<Repo>>

}