package com.gustavoforero.wesendtest.utils

import android.arch.persistence.room.TypeConverter
import java.util.*

open class DateUtil {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong == null) null else Date(dateLong)
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return (date?.time)
    }

}