package com.example.hotelapplication.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(indices = [Index(value = ["phone", "email"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id") var user_id: Int = 0,
    @ColumnInfo(name = "account") var account: String?,
    @ColumnInfo(name = "user_name") @Nonnull var user_name: String,
    @ColumnInfo(name = "date_of_birth") var date_of_birth: String?,
    @ColumnInfo(name = "phone") @Nonnull var phone: String,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "password") @Nonnull var password: String,
    @ColumnInfo(name = "reset_psw_code") var reset_psw_code: String?,
)