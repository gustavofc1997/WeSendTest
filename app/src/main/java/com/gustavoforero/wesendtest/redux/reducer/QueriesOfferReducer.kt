package com.gustavoforero.wesendtest.redux.reducer

import com.gustavoforero.wesendtest.redux.ShowCurrentBTCOffer
import com.gustavoforero.wesendtest.redux.states.BTCOfferState
import org.rekotlin.Action

fun queriesOfferReducer(action: Action, btcOfferState: BTCOfferState?): BTCOfferState {

    var state = btcOfferState ?: BTCOfferState()
    when (action) {
        is ShowCurrentBTCOffer -> {
            state = state.copy(offer = action.offer)
        }
    }
    return state
}