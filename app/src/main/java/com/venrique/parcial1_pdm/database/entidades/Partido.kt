package com.venrique.parcial1_pdm.database.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidos")
data class Partido(@ColumnInfo(name = "equipo_uno") val eq1: String,
                   @ColumnInfo(name = "equipo_dos") val eq2: String,
                   @ColumnInfo(name = "puntaje_e1") val pEq1: Int,
                   @ColumnInfo(name = "puntaje_e2") val pEq2: Int,
                   @ColumnInfo(name = "fecha") val date: String){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long = 0

}