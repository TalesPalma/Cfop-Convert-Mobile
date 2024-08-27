package com.talespalma.cfopconvertmobile.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
    abstract fun cfopRevendaDao(): CfopRevendaDao
    abstract fun cfopIndustrializacaoDao(): CfopIndustrializacaoDao
    abstract fun cfopConsumoDao(): CfopConsumoDao

    // O Hilt cuida disso aqui agora.
    // VEJA O DatabaseModule é muito legal isso.
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//        fun getInstance(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "cfop_conver_database"
//                )
//                    .createFromAsset("database/cfops.db")
//                    .fallbackToDestructiveMigration()
//                    .build()
//                    .also { INSTANCE = it }
//            }

//        }
//    }

}



