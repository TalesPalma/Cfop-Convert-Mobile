package com.talespalma.cfopconvertmobile.database.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.talespalma.cfopconvertmobile.models.CfopDTO

@Entity(tableName = "cfop_industrializacao")
data class CfopIndustrializacao(
    @PrimaryKey val code : String,
    @ColumnInfo val converting: String,
){
    fun converterToDto() = CfopDTO(
        code = code,
        covertindCode = converting
    )
}
