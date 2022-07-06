package com.example.checkinghomework.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.checkinghomework.model.UserModel

@Dao
interface IUserDao {

    @Query("SELECT * FROM user_table")
    fun getAllItem(): LiveData<UserModel?>?

    @Query("SELECT * FROM user_table where username = :username and password = :pass")
    fun getByLogin(username: String?, pass: String?): UserModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(usersModel: UserModel?)

}