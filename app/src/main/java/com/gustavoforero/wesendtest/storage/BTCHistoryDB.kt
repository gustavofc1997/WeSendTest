package com.gustavoforero.wesendtest.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.gustavoforero.wesendtest.data.model.QueryBTC

@Database(entities = [(QueryBTC::class)], version = 1)
abstract class BTCHistoryDB : RoomDatabase() {
    abstract fun queryDao(): QueryDao
}