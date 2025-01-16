package com.example.hotelapplication.repositories

interface StoreValue {
    fun getStringValue(key: String): String
    fun setStringValue(key: String, value: String)
    fun getIntValue(key: String): Int
    fun setIntValue(key: String, value: Int)
    fun getLongValue(key: String): Long
    fun setLongValue(key: String, value: Long)
    fun getBooleanValue(key: String): Boolean
    fun setBooleanValue(key: String, value: Boolean)
    fun getFloatValue(key: String): Float
    fun setFloatValue(key: String, value: Float)
}