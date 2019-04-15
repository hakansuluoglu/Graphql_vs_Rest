package com.hakansu.restgraphql.presentation.graphql

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.hakansu.restgraphql.R
import com.hakansu.restgraphql.App
import javax.inject.Inject

open class GraphqlFragment  : Fragment(){

    @Inject
    lateinit var graphqlPresenter: GraphqlPresenter

    companion object {
         fun newInstance(): GraphqlFragment {
            return GraphqlFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_graphql, container, false)
        ButterKnife.bind(this,rootView)
        naber()
        return rootView
    }

    fun naber() {
        graphqlPresenter.calis()
    }


}

