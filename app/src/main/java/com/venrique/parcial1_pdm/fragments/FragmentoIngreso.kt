package com.venrique.parcial1_pdm.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationItemView

import com.venrique.parcial1_pdm.R
import com.venrique.parcial1_pdm.database.entidades.Partido
import com.venrique.parcial1_pdm.databinding.FragmentFragmentoIngresoBinding
import com.venrique.parcial1_pdm.viewmodel.PuntosViewModel
import com.venrique.parcial1_pdm.viewmodel.partidoViewModel
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentoIngreso.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FragmentoIngreso.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentoIngreso : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    lateinit var btnGuardar: BottomNavigationItemView
    lateinit var btnBorrar: BottomNavigationItemView
    lateinit var scoreViewModel: PuntosViewModel
    lateinit var tv_score_team_a: TextView
    lateinit var tv_score_team_b: TextView
    lateinit var btn_uno:Button
    lateinit var btn_dos:Button
    lateinit var btn_tres:Button
    lateinit var btn_uno2:Button
    lateinit var btn_dos2:Button
    lateinit var btn_tres2:Button
    lateinit var et_nombre1:EditText
    lateinit var et_nombre2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        scoreViewModel = ViewModelProviders.of(this).get(PuntosViewModel::class.java)
        val vista = inflater.inflate(R.layout.fragment_fragmento_ingreso, container, false)

        tv_score_team_a = vista.findViewById(R.id.puntos_eq1)
        tv_score_team_b = vista.findViewById(R.id.puntos_eq2)
        btn_uno = vista.findViewById(R.id.btn_uno)
        btn_dos = vista.findViewById(R.id.btn_dos)
        btn_tres = vista.findViewById(R.id.btn_tres)
        btn_uno2 = vista.findViewById(R.id.btn_uno_eq2)
        btn_dos2 = vista.findViewById(R.id.btn_dos_eq2)
        btn_tres2 = vista.findViewById(R.id.btn_tres_eq2)
        btnBorrar = vista.findViewById(R.id.borrar)
        btnGuardar = vista.findViewById(R.id.guardar)
        et_nombre1 = vista.findViewById(R.id.et_equipo1Name)
        et_nombre2 = vista.findViewById(R.id.et_equipo2Name)

        DataBindingUtil.inflate<FragmentFragmentoIngresoBinding>(
            inflater,R.layout.fragment_fragmento_ingreso,container,false
        ).apply {
            this.puntos = scoreViewModel
        }

        val pointsObserverA = Observer<Int>{ newPoint ->
            tv_score_team_a.text = newPoint.toString()
        }

        val pointsObserverB = Observer<Int>{ newPoint ->
            tv_score_team_b.text = newPoint.toString()
        }

        scoreViewModel.scoreTeamA.observe(this,pointsObserverA)
        scoreViewModel.scoreTeamB.observe(this,pointsObserverB)

        btn_uno.setOnClickListener { scoreViewModel.sumar(1,"equipoA") }
        btn_dos.setOnClickListener { scoreViewModel.sumar(2,"equipoA") }
        btn_tres.setOnClickListener { scoreViewModel.sumar(3,"equipoA") }
        btn_uno2.setOnClickListener { scoreViewModel.sumar(1,"equipoB") }
        btn_dos2.setOnClickListener { scoreViewModel.sumar(2,"equipoB") }
        btn_tres2.setOnClickListener { scoreViewModel.sumar(3,"equipoB") }
        btnBorrar.setOnClickListener { scoreViewModel.reset() }

        btnGuardar.setOnClickListener {
            val viewModel = ViewModelProviders.of(this).get(partidoViewModel::class.java)

            val df = SimpleDateFormat("EEE, d MMM yyyy HH:mm")

            if(et_nombre1.text.toString() != "" && et_nombre2.text.toString() != ""){
                viewModel.insert(Partido(et_nombre1.text.toString(),
                    et_nombre2.text.toString(),
                    tv_score_team_a.text.toString().toInt(),
                    tv_score_team_b.text.toString().toInt(),
                    df.format(Calendar.getInstance().time)))

                val fragmentoInicio = FragmentoInicio()

                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.containerFrag, fragmentoInicio)?.addToBackStack(null)?.commit()
            }else{
                Toast.makeText(context,"Ingrese los nombres de los equipos.",Toast.LENGTH_LONG).show()
            }


        }

        return vista
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentoIngreso.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentoIngreso().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
