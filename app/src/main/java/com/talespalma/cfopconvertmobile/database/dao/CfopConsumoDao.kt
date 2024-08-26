package com.talespalma.cfopconvertmobile.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.talespalma.cfopconvertmobile.database.entitys.CfopConsumo

@Dao
interface CfopConsumoDao {
    @Query("SELECT * FROM cfop_consumo")
    fun getAll(): List<CfopConsumo>

    @Insert()
    fun insert(cfopConsumo: CfopConsumo)

}