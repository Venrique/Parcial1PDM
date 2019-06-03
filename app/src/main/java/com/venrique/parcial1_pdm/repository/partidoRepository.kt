package com.venrique.parcial1_pdm.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.venrique.parcial1_pdm.database.DAO.partidoDAO
import com.venrique.parcial1_pdm.database.entidades.Partido

class partidoRepository(private val partidoDao: partidoDAO) {

    @WorkerThread
    suspend fun insert(partido: Partido){
        partidoDao.insert(partido)
    }

    fun getAll(): LiveData<List<Partido>>{
        return partidoDao.getAll()
    }

    fun deteleAll(){
        partidoDao.deleteAll()
    }

    fun deleteOne(id:Int){
        partidoDao.deleteOne(id)
    }
}