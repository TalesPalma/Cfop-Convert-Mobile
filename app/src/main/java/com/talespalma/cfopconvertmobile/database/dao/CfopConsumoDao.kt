package com.talespalma.cfopconvertmobile.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.talespalma.cfopconvertmobile.database.entitys.CfopConsumo
import com.talespalma.cfopconvertmobile.models.Cfop
import kotlinx.coroutines.flow.Flow

@Dao
interface CfopConsumoDao {
    @Query("SELECT * FROM cfop_consumo")
    fun getAll(): Flow<List<CfopConsumo>>



}