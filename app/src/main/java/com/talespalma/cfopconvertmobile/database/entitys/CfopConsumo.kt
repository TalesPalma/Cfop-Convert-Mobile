package com.talespalma.cfopconvertmobile.database.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.talespalma.cfopconvertmobile.models.CfopDTO

@Entity(tableName = "cfop_consumo")
data class CfopConsumo(
    @PrimaryKey val code : String,
    @ColumnInfo val converting: String,
) : ICfopEntity{
    override fun converterToDto() = CfopDTO(
        code = code,
        covertindCode = converting
    )
}
