package com.gustavoforero.wesendtest.redux.reducer

import com.gustavoforero.wesendtest.redux.states.AppState
import org.rekotlin.Action

fun appReducer(action: Action, appState: AppState?): AppState =
    AppState(
        QueryListBTCState = queriesListReducer(action, appState?.QueryListBTCState),
        queryOfferBTCState = queriesOfferReducer(action, appState?.queryOfferBTCState)
    )