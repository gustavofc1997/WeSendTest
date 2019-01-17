package com.gustavoforero.wesendtest.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.gustavoforero.wesendtest.utils.DateUtil
import java.util.*

@Entity(tableName = "queriesBTC")
data class QueryBTC(
    @ColumnInfo(name = "rate") val rate: Double,
    @ColumnInfo(name = "atypical") val atypical: Int,
    @ColumnInfo(name = "date") val queryDate: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}