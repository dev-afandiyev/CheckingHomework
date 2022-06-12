package com.example.checkinghomework.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.checkinghomework.model.UserModel

@Dao
interface IUserDao {

    @Query("SELECT * FROM user_table")
    fun getAllItem(): LiveData<UserModel?>?

    @Query("SELECT * FROM user_table where email = :email and password = :pass")
    fun getByLogin(email: String?, pass: String?): UserModel?

    @Insert
    fun insert(usersModel: UserModel?)


}