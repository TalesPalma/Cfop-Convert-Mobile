package com.talespalma.cfopconvertmobile.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.talespalma.cfopconvertmobile.database.entitys.CfopRevenda
import kotlinx.coroutines.flow.Flow

@Dao
interface CfopRevendaDao {

    @Query("SELECT * FROM cfop_revenda")
    fun getAll(): Flow<List<CfopRevenda>>



}