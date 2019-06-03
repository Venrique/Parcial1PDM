package com.venrique.parcial1_pdm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PuntosViewModel: ViewModel() {
    private val _scoreTeamA = MutableLiveData<Int>()
    val scoreTeamA: LiveData<Int>
        get() = _scoreTeamA

    private val _scoreTeamB = MutableLiveData<Int>()
    val scoreTeamB: LiveData<Int>
        get() = _scoreTeamB

    init {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }

    fun sumar(cantidad: Int,equipo: String){

        if (equipo=="equipoA"){
            val punto: Int = scoreTeamA.value!!.toInt()
            _scoreTeamA.value = punto+cantidad
        }else if (equipo=="equipoB"){
            val punto: Int = scoreTeamB.value!!.toInt()
            _scoreTeamB.value = punto+cantidad
        }
    }

    fun reset(){
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }
}