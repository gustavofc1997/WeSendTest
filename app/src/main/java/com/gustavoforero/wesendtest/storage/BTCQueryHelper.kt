package com.gustavoforero.wesendtest.storage

import com.gustavoforero.wesendtest.Application
import com.gustavoforero.wesendtest.data.model.QueryBTC
import com.gustavoforero.wesendtest.utils.executeRxFun

class BTCQueryHelper {

    companion object {

        fun insertQueryAsync(queryOffer: QueryBTC?, listener: () -> Unit) {
            queryOffer?.let {
                executeRxFun(
                    heavyFunction = { Application.btcQueriesDb?.queryDao()?.insert(it) },
                    response = { listener.invoke() }
                )
            }

        }

        fun getStoredQueries(listener: (List<QueryBTC>?) -> Unit) {
            executeRxFun(
                heavyFunction = { Application.btcQueriesDb?.queryDao()?.getAll() },
                response = { listener.invoke(it) }
            )
        }
    }
}