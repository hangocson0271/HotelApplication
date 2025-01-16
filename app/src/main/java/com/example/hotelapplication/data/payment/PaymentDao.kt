package com.example.hotelapplication.data.payment

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PaymentDao {

    @Insert fun insert(payment: Payment) : Long
    @Insert
    suspend fun insertAll(payments: List<Payment>) : List<Long>

}