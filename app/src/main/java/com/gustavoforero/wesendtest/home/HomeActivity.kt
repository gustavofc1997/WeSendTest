package com.gustavoforero.wesendtest.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gustavoforero.wesendtest.R
import com.gustavoforero.wesendtest.btcoffers.BTCOffersActivity
import com.gustavoforero.wesendtest.data.model.QueryBTC
import com.gustavoforero.wesendtest.redux.InitQueriesListAction
import com.gustavoforero.wesendtest.redux.states.QueryListBTCState
import com.gustavoforero.wesendtest.store
import kotlinx.android.synthetic.main.activity_home.*
import org.rekotlin.StoreSubscriber

class HomeActivity : AppCompatActivity(), StoreSubscriber<QueryListBTCState?> {

    private val adapter = QueriesListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
    }

    override fun onStart() {
        super.onStart()
        store.subscribe(this) {
            it.select { AppState -> AppState.QueryListBTCState }
        }
    }

    override fun onStop() {
        super.onStop()
        store.unsubscribe(this)
    }

    override fun newState(state: QueryListBTCState?) {
        state?.queryList?.let {
            initializeAdapter(it)
        }
    }

    private fun initializeAdapter(queryList: List<QueryBTC>) {
        adapter.addData(queryList)
    }

    private fun initViews() {
        title = getString(R.string.title_home_history)
        rvQueryList.adapter = adapter
        fabQuery.setOnClickListener { newQuery() }
        store.dispatch(InitQueriesListAction())
    }

    private fun newQuery() {
        startActivity(BTCOffersActivity.newIntent(this))
    }

}
