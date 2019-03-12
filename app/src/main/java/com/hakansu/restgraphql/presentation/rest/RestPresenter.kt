package com.hakansu.restgraphql.presentation.both

import android.util.Log
import com.hakansu.restgraphql.data.Repository
import com.hakansu.restgraphql.data.model.Repo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class RestPresenter @Inject constructor(var repository: Repository){

    var disposable = CompositeDisposable()

    fun calis(){
        disposable.add(repository.getGitRepos().subscribeWith(GetContentsObserver()))
    }

    private inner class GetContentsObserver : DisposableSingleObserver<List<Repo>>() {

        override fun onSuccess(t: List<Repo>) {
            Log.d("HATA", t.get(0).description)
        }


        override fun onError(e: Throwable) {
            Log.d("HATA", e.localizedMessage)
        }
    }
}