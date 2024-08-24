package com.talespalma.cfopconvertmobile.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.talespalma.cfopconvertmobile.database.dao.CfopConsumoDao
import com.talespalma.cfopconvertmobile.database.dao.CfopIndustrializacaoDao
import com.talespalma.cfopconvertmobile.database.dao.CfopRevendaDao
import com.talespalma.cfopconvertmobile.database.entitys.CfopConsumo
import com.talespalma.cfopconvertmobile.database.entitys.CfopIndustrializacao
import com.talespalma.cfopconvertmobile.database.entitys.CfopRevenda

@Database(
    entities = [CfopRevenda::class, CfopIndustrializacao::class, CfopConsumo::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cfopRevendaDao() : CfopRevendaDao
    abstract  fun cfopIndustrializacaoDao() : CfopIndustrializacaoDao
    abstract  fun cfopConsumoDao() : CfopConsumoDao
 }