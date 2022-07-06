package com.example.checkinghomework.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserModel(
    val username: String,
    val email: String,
    val password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0
}
