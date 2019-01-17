package com.gustavoforero.wesendtest.redux.middlewares

import com.gustavoforero.wesendtest.data.model.QueryBTC
import com.gustavoforero.wesendtest.redux.AddQuery
import com.gustavoforero.wesendtest.redux.ShowQueryHistory
import com.gustavoforero.wesendtest.redux.states.AppState
import com.gustavoforero.wesendtest.storage.BTCQueryHelper
import org.rekotlin.DispatchFunction
import org.rekotlin.Middleware

internal val databaseMiddleWare: Middleware<AppState> = { dispatch, _ ->
    { next ->
        { action ->
            when (action) {
                is AddQuery -> {
                    insertBTCQuery(action.query, dispatch)
                }
            }
            next(action)
        }
    }
}

private fun insertBTCQuery(queryBTC: QueryBTC?, dispatch: DispatchFunction) {
    BTCQueryHelper.insertQueryAsync(queryBTC) {
        displayAllQueries(dispatch)
    }
}

private fun displayAllQueries(dispatch: DispatchFunction) {
    BTCQueryHelper.getStoredQueries { list ->
        list?.apply {
            dispatch(ShowQueryHistory(list))
        }
    }
}