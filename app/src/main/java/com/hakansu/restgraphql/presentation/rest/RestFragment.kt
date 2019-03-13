package com.hakansu.restgraphql.presentation.rest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.hakansu.restgraphql.R
import com.hakansu.restgraphql.App
import com.hakansu.restgraphql.presentation.both.RestPresenter
import javax.inject.Inject

class RestFragment : Fragment(){

    @Inject
    lateinit var restPresenter: RestPresenter

    companion object {
        fun newInstance(): RestFragment {
            return RestFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_rest, container, false)
        ButterKnife.bind(this,rootView)
        naber()
        return rootView
    }

    fun naber(){
        restPresenter.calis()
    }
}

