package com.talespalma.cfopconvertmobile.database.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cfop_consumo")
data class CfopConsumo(
    @PrimaryKey val code : String,
    @ColumnInfo val converting: String,
)
