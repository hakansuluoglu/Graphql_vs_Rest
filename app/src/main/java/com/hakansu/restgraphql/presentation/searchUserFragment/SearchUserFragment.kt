package com.hakansu.restgraphql.presentation.searchUserFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hakansu.restgraphql.R
import com.hakansu.restgraphql.App
import javax.inject.Inject

class SearchUserFragment : Fragment(){

    @Inject
    lateinit var searchUserPresenter: SearchUserPresenter

    companion object {
        fun newInstance(): SearchUserFragment {
            return SearchUserFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_rest, container, false)
        naber()
        return rootView
    }

    fun naber(){
        searchUserPresenter.calis()
        searchUserPresenter.calisGraphql()
    }

}

