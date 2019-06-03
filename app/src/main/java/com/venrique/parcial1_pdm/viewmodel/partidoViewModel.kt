package com.venrique.parcial1_pdm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.venrique.parcial1_pdm.database.RoomDB
import com.venrique.parcial1_pdm.database.entidades.Partido
import com.venrique.parcial1_pdm.repository.partidoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class partidoViewModel(app: Application): AndroidViewModel(app){
    val repository: partidoRepository
    init {
        val partidoDao = RoomDB.getInstance(app).partidoDao()
        repository = partidoRepository(partidoDao)
    }

    fun insert(partido: Partido)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(partido)
    }

    fun getAll():LiveData<List<Partido>>{
        return repository.getAll()
    }

    fun deleteOne(id: Int) = repository.deleteOne(id)
}