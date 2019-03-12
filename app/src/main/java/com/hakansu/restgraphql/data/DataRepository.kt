package com.hakansu.restgraphql.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.Rx2Apollo
import com.hakansu.restgraphql.GitReposQuery
import com.hakansu.restgraphql.data.rest.RestClient
import com.hakansu.restgraphql.domain.Repository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor() :Repository {

    @Inject lateinit var apolloClient: ApolloClient
    @Inject lateinit var restClient: RestClient

    override fun getGitRepos(naber: Int): Observable<Response<GitReposQuery.Data>> {
        val entryDetailQuery = apolloClient.query(GitReposQuery(naber))

        return Rx2Apollo
            .from(entryDetailQuery)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getGitRepos(): Single<List<Repository>> {
        return restClient.restApi.getRepos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}