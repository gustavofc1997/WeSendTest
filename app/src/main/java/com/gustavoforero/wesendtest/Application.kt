package com.gustavoforero.wesendtest

import android.app.Application
import android.arch.persistence.room.Room
import com.gustavoforero.wesendtest.redux.middlewares.BTCQueriesMiddleWare
import com.gustavoforero.wesendtest.redux.middlewares.QueryApiMiddleware
import com.gustavoforero.wesendtest.redux.middlewares.databaseMiddleWare
import com.gustavoforero.wesendtest.redux.reducer.appReducer
import com.gustavoforero.wesendtest.storage.BTCHistoryDB
import com.gustavoforero.wesendtest.utils.AppConstants
import org.rekotlin.Store

val store = Store(
    reducer = ::appReducer,
    state = null,
    middleware = listOf(BTCQueriesMiddleWare, databaseMiddleWare, QueryApiMiddleware)
)

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        btcQueriesDb = Room
            .databaseBuilder(this, BTCHistoryDB::class.java, AppConstants.DB_NAME)
            .build()
    }

    companion object {
        var btcQueriesDb: BTCHistoryDB? = null
    }
}