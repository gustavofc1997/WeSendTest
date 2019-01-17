package com.gustavoforero.wesendtest.utils

import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


fun <T> executeRxFun(heavyFunction: () -> T, response: (response: T?) -> Unit) {
    val observable = Single.create<T> { e ->
        e.onSuccess(heavyFunction())
    }
    observable.subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { t: T? ->
            response(t)
        }

}

