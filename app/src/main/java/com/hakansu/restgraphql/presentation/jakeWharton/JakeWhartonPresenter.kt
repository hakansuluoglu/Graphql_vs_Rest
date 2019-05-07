package com.hakansu.restgraphql.presentation.both

import android.util.Log
import com.apollographql.apollo.api.Response
import com.hakansu.restgraphql.GitReposQuery
import com.hakansu.restgraphql.data.Repository
import com.hakansu.restgraphql.data.model.Repo
import com.hakansu.restgraphql.fragment.RepositoryFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class JakeWhartonPresenter @Inject constructor(var repository: Repository) {

    var disposable = CompositeDisposable()

    fun calis() {
        disposable.add(repository.getGitRepos().subscribeWith(GetContentsObserverRest()))
    }


    fun calisGraphql(){
        disposable.add(repository
            .getGitRepos(3)
            .singleOrError()
            .subscribeWith(GetContentsObserverGraphql()))
    }

    private inner class GetContentsObserverRest : DisposableSingleObserver<List<Repo>>() {

        override fun onSuccess(t: List<Repo>) {
            Log.d("AY", t.get(0).description)
        }


        override fun onError(e: Throwable) {
            Log.d("AY", e.localizedMessage)
        }
    }

    private inner class GetContentsObserverGraphql : DisposableSingleObserver<Response<GitReposQuery.Data>>() {
        override fun onSuccess(t: Response<GitReposQuery.Data>) {
            Log.d("AY", mapResponseToRepositories(t).get(0).description())

        }

        override fun onError(e: Throwable) {
            Log.d("AY", e.localizedMessage)
        }
    }

    private fun mapResponseToRepositories(response: Response<GitReposQuery.Data>): List<RepositoryFragment> {
        return response.data()?.viewer()?.repositories()?.nodes()?.map{it.fragments().repositoryFragment()} ?: emptyList()
    }

}