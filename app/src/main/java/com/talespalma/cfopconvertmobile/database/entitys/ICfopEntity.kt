package com.talespalma.cfopconvertmobile.database.entitys

import com.talespalma.cfopconvertmobile.models.CfopDTO

interface ICfopEntity {
    fun converterToDto(): CfopDTO
}