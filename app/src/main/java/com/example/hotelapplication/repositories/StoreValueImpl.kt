package com.example.hotelapplication.repositories

import android.content.Context
import com.example.hotelapplication.constant.SharePreferenceConstant
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StoreValueImpl @Inject constructor(
    @ApplicationContext context: Context,
) : StoreValue {

    private val sharedPreferences = context.getSharedPreferences(
        SharePreferenceConstant.HOTEL_SHARE_PREFERENCE_NAME, Context.MODE_PRIVATE)

    override fun getStringValue(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

    override fun setStringValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getIntValue(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    override fun setIntValue(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    override fun getLongValue(key: String): Long {
        return sharedPreferences.getLong(key, 0L)
    }

    override fun setLongValue(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    override fun getBooleanValue(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    override fun setBooleanValue(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun getFloatValue(key: String): Float {
        return sharedPreferences.getFloat(key, 0f)
    }

    override fun setFloatValue(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }
}