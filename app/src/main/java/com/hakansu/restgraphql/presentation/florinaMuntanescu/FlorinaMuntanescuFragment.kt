package com.hakansu.restgraphql.presentation.florinaMuntanescu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.hakansu.restgraphql.R
import com.hakansu.restgraphql.App
import com.hakansu.restgraphql.presentation.both.FlorinaMuntanescuPresenter
import com.hakansu.restgraphql.presentation.both.JakeWhartonPresenter
import javax.inject.Inject

class FlorinaMuntanescuFragment : Fragment(){

    @Inject
    lateinit var jakeWhartonPresenter: FlorinaMuntanescuPresenter

    companion object {
        fun newInstance(): FlorinaMuntanescuFragment {
            return FlorinaMuntanescuFragment()
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
        jakeWhartonPresenter.calis()
        jakeWhartonPresenter.calisGraphql()
    }
}

