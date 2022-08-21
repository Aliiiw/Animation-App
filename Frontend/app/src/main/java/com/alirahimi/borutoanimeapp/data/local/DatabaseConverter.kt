package com.alirahimi.borutoanimeapp.data.local

import androidx.room.TypeConverter
import java.lang.StringBuilder

class DatabaseConverter {
    private val separator = ","

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()

        for (string in list) {
            stringBuilder.append(string).append(separator)
        }

        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {

        return string.split(separator)

    }
}