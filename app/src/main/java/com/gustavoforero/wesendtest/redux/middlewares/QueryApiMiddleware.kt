package com.gustavoforero.wesendtest.redux.middlewares

import com.gustavoforero.wesendtest.data.remote.model.BTCResponse
import com.gustavoforero.wesendtest.data.remote.RestClient
import com.gustavoforero.wesendtest.redux.SearchBTCOffersAction
import com.gustavoforero.wesendtest.redux.ShowCurrentBTCOffer
import com.gustavoforero.wesendtest.redux.states.AppState
import com.gustavoforero.wesendtest.utils.OfferToQueryMapper
import org.rekotlin.DispatchFunction
import org.rekotlin.Middleware
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


internal val QueryApiMiddleware: Middleware<AppState> = { dispatch, _ ->
    { next ->
        { action ->
            when (action) {
                is SearchBTCOffersAction -> {
                    getOffers(dispatch)
                }
            }
            next(action)
        }
    }
}

private fun getOffers(dispatch: DispatchFunction) {
    val restClient = RestClient()
    restClient.getApi().offers.enqueue(object : Callback<BTCResponse> {
        override fun onFailure(call: Call<BTCResponse>?, t: Throwable?) {

        }

        override fun onResponse(call: Call<BTCResponse>?, response: Response<BTCResponse>?) {
            dispatch(ShowCurrentBTCOffer(OfferToQueryMapper.apply(response?.body()?.data?.ad_list!!)))
        }
    })
}
