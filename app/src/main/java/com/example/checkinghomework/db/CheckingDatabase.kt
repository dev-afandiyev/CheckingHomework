package com.example.checkinghomework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.checkinghomework.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class CheckingDatabase : RoomDatabase() {
    abstract fun usersDao(): IUserDao?
}