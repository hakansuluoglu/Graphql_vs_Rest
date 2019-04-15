package com.hakansu.restgraphql.presentation.graphql

import android.util.Log
import com.apollographql.apollo.api.Response
import com.hakansu.restgraphql.GitReposQuery
import com.hakansu.restgraphql.data.Repository
import com.hakansu.restgraphql.data.model.Repo
import com.hakansu.restgraphql.fragment.RepositoryFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class GraphqlPresenter @Inject constructor(var repository: Repository) : GraphqlContact{

    var disposable = CompositeDisposable()

    fun calis(){
        disposable.add(repository
                        .getGitRepos(3)
                        .singleOrError()
                        .subscribeWith(GetContentsObserver()))
    }

    private inner class GetContentsObserver : DisposableSingleObserver<Response<GitReposQuery.Data>>() {
        override fun onSuccess(t: Response<GitReposQuery.Data>) {
            Log.d("HATA", mapResponseToRepositories(t).get(0).description())

        }

        override fun onError(e: Throwable) {
            Log.d("HATA", e.localizedMessage)
        }
    }

    private fun mapResponseToRepositories(response: Response<GitReposQuery.Data>): List<RepositoryFragment> {
        return response.data()?.viewer()?.repositories()?.nodes()?.map{it.fragments().repositoryFragment()} ?: emptyList()
    }


}

