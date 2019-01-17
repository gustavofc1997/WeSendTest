package com.gustavoforero.wesendtest.redux.reducer

import com.gustavoforero.wesendtest.redux.ShowQueryHistory
import com.gustavoforero.wesendtest.redux.states.QueryListBTCState
import org.rekotlin.Action

fun queriesListReducer(action: Action, queryListState: QueryListBTCState?): QueryListBTCState {
    var state = queryListState ?: QueryListBTCState()
    when (action) {
        is ShowQueryHistory -> {
            state = state.copy(queryList = action.query)
        }
    }
    return state
}