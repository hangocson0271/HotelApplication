package com.example.hotelapplication.data.payment

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PaymentRepositoryImpl( private val paymentDao: PaymentDao) : PaymentRepository {
    override suspend fun insert(payment: Payment): Long {
        return try {
            withContext(Dispatchers.IO) {
                Log.i("TAG", "Before insert in PaymentRepositoryImpl")
                paymentDao.insert(payment)
            }
        } catch (e: Exception){
            Log.i("TAG", "Exception PaymentRepositoryImpl ${e.toString()}")
            return -1
        }
    }

    override suspend fun insertAll(payments: List<Payment>): List<Long> {
        return paymentDao.insertAll(payments)
    }
}