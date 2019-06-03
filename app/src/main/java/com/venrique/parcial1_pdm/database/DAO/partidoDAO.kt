package com.venrique.parcial1_pdm.database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.venrique.parcial1_pdm.database.entidades.Partido

@Dao
interface partidoDAO {

    @Insert
    suspend fun insert(partido: Partido)

    @Query("SELECT * FROM partidos")
    fun getAll(): LiveData<List<Partido>>

    @Query("DELETE FROM partidos")
    fun deleteAll()

    @Query("DELETE FROM partidos where id=:id")
    fun deleteOne(id: Int)

}