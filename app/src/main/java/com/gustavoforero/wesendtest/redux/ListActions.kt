package com.gustavoforero.wesendtest.redux

import com.gustavoforero.wesendtest.data.model.QueryBTC
import com.gustavoforero.wesendtest.data.remote.model.Offer
import org.rekotlin.Action

class InitQueriesListAction : Action

class SearchBTCOffersAction : Action

class ShowCurrentBTCOffer(val offer: QueryBTC) : Action

class ShowQueryHistory(val query: List<QueryBTC>) : Action

class AddQuery(val query: QueryBTC?) : Action