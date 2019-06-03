package com.venrique.parcial1_pdm

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.internal.NavigationMenuItemView
import com.venrique.parcial1_pdm.fragments.FragmentoIngreso
import com.venrique.parcial1_pdm.fragments.FragmentoInicio
import com.venrique.parcial1_pdm.fragments.FragmentoPartidos

class MainActivity : AppCompatActivity(), FragmentoIngreso.OnFragmentInteractionListener,FragmentoPartidos.OnFragmentInteractionListener, FragmentoInicio.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var fragmentoInicio: FragmentoInicio


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentoInicio = FragmentoInicio()
        supportFragmentManager.beginTransaction().add(R.id.containerFrag,fragmentoInicio).commit()

    }
}
