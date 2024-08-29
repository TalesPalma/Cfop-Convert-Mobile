package com.talespalma.cfopconvertmobile.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.talespalma.cfopconvertmobile.database.entitys.CfopIndustrializacao
import kotlinx.coroutines.flow.Flow


@Dao
interface CfopIndustrializacaoDao {
    @Query("SELECT * FROM cfop_industrializacao")
    fun getAll(): Flow<List<CfopIndustrializacao>>
}