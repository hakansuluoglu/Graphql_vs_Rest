package com.hakansu.restgraphql.presentation.both

import android.util.Log
import com.hakansu.restgraphql.domain.Repository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class RestPresenter @Inject constructor(var repository: Repository){

    var disposable = CompositeDisposable()

    fun calis(){
        disposable.add(repository.getGitRepos().subscribeWith(GetContentsObserver()))
    }

    private inner class GetContentsObserver : DisposableSingleObserver<List<Repository>>() {

        override fun onSuccess(t: List<Repository>) {
            Log.d("HATA", t.toString())
        }


        override fun onError(e: Throwable) {
            Log.d("HATA", e.localizedMessage)
        }
    }
}