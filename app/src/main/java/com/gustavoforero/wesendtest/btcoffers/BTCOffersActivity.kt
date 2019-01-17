package com.gustavoforero.wesendtest.btcoffers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.content.Context
import android.databinding.DataBindingUtil
import com.gustavoforero.wesendtest.R
import com.gustavoforero.wesendtest.redux.SearchBTCOffersAction
import com.gustavoforero.wesendtest.redux.states.BTCOfferState
import com.gustavoforero.wesendtest.store
import org.rekotlin.StoreSubscriber
import com.gustavoforero.wesendtest.databinding.ActivityBtcOfferBinding
import com.gustavoforero.wesendtest.redux.AddQuery
import android.support.v4.app.ActivityCompat
import android.view.MenuItem
import android.view.View
import com.gustavoforero.wesendtest.data.model.QueryBTC
import kotlinx.android.synthetic.main.activity_btc_offer.*


class BTCOffersActivity : AppCompatActivity(), StoreSubscriber<BTCOfferState?> {


    lateinit var mActivityBinding: ActivityBtcOfferBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_btc_offer)
        initViews()
    }

    override fun onStart() {
        super.onStart()
        store.subscribe(this) {
            it.select { AppState -> AppState.queryOfferBTCState }
        }
    }

    override fun onStop() {
        super.onStop()
        store.unsubscribe(this)
    }

    override fun newState(state: BTCOfferState?) {
        state?.offer?.let {
            pbRate.visibility = View.GONE
            mActivityBinding.offer = it
        }
    }


    private fun saveQuery(query: QueryBTC) {
       store.dispatch(AddQuery(query))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> ActivityCompat.finishAfterTransition(this)
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initViews() {
        title = getString(R.string.title_btc_offer)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        pbRate.visibility = View.VISIBLE
        store.dispatch(SearchBTCOffersAction())

    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, BTCOffersActivity::class.java)
        }
    }


}