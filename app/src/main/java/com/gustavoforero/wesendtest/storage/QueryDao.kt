package com.gustavoforero.wesendtest.storage

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.gustavoforero.wesendtest.data.model.QueryBTC

@Dao
interface QueryDao {

    @Query("SELECT * from queriesBTC")
    fun getAll(): List<QueryBTC>

    @Insert
    fun insert(query: QueryBTC)

}