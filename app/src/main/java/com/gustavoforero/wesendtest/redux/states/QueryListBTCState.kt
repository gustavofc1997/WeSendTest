package com.gustavoforero.wesendtest.redux.states

import com.gustavoforero.wesendtest.data.model.QueryBTC
import org.rekotlin.StateType

data class QueryListBTCState(var queryList: List<QueryBTC>? = null) : StateType