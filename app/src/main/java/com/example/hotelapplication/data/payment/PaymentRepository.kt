package com.example.hotelapplication.data.payment



interface
PaymentRepository {
 suspend fun insert(payment: Payment) : Long
 suspend fun insertAll(payments: List<Payment>) : List<Long>
}