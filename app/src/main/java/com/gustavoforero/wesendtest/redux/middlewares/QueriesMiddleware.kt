package com.gustavoforero.wesendtest.redux.middlewares

import com.gustavoforero.wesendtest.redux.InitQueriesListAction
import com.gustavoforero.wesendtest.redux.ShowQueryHistory
import com.gustavoforero.wesendtest.redux.states.AppState
import com.gustavoforero.wesendtest.storage.BTCQueryHelper
import org.rekotlin.DispatchFunction
import org.rekotlin.Middleware

internal val BTCQueriesMiddleWare: Middleware<AppState> = { dispatch, _ ->
    { next ->
        { action ->
            when (action) {
                is InitQueriesListAction -> {
                    getQueriesList(dispatch)
                }
            }
            next(action)
        }
    }
}

private fun getQueriesList(dispatch: DispatchFunction) {
    BTCQueryHelper.getStoredQueries { list ->
        list?.apply {
            dispatch(ShowQueryHistory(list))
        }
    }
}