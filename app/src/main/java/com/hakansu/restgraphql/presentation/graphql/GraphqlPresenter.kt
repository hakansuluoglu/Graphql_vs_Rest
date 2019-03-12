package com.hakansu.restgraphql.presentation.graphql

import android.util.Log
import com.apollographql.apollo.api.Response
import com.hakansu.restgraphql.GitReposQuery
import com.hakansu.restgraphql.data.Repository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class GraphqlPresenter @Inject constructor(var repository: Repository) {

    var disposable = CompositeDisposable()

    fun calis(){
        disposable.add(repository.getGitRepos(3).singleOrError().subscribeWith(GetContentsObserver()))
    }

    private inner class GetContentsObserver : DisposableSingleObserver<Response<GitReposQuery.Data>>() {
        override fun onSuccess(t: Response<GitReposQuery.Data>) {
            Log.d("HATA", t.data().toString())

        }

        override fun onError(e: Throwable) {
            Log.d("HATA", e.localizedMessage)
            //this@GraphqlPresenter.homeView.showSnackBar(e.message)
        }
    }

}

