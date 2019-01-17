package com.gustavoforero.wesendtest.redux.states

import org.rekotlin.StateType

data class AppState(
    var QueryListBTCState: QueryListBTCState? = null, var queryOfferBTCState: BTCOfferState? = null
) : StateType