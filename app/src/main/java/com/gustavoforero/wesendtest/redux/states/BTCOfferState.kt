package com.gustavoforero.wesendtest.redux.states

import com.gustavoforero.wesendtest.data.model.QueryBTC
import org.rekotlin.StateType

data class BTCOfferState(var offer: QueryBTC? = null) : StateType