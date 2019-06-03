package com.venrique.parcial1_pdm.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.venrique.parcial1_pdm.R
import com.venrique.parcial1_pdm.database.entidades.Partido

class partidoAdapter: RecyclerView.Adapter<partidoAdapter.partidoViewHolder>() {

    private var partidos = emptyList<Partido>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): partidoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.partidos_list,parent,false)

        return partidoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return partidos.size
    }

    internal fun setPartidos(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: partidoViewHolder, position: Int) {
        val current = partidos[position]

        holder.txtNombreUno.text = current.eq1
        holder.txtNombreDos.text = current.eq2
        holder.txtPuntajeUno.text = current.pEq1.toString()
        holder.txtPuntajeDos.text = current.pEq2.toString()
        if(current.pEq1>current.pEq2){
            holder.txtPuntajeUno.setTextColor(Color.parseColor("#ffff72"))
        }else{
            holder.txtPuntajeDos.setTextColor(Color.parseColor("#ffff72"))
        }
        holder.txtFecha.text = current.date
    }

    class partidoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtNombreUno: TextView = itemView.findViewById(R.id.rv_nombre1)
        val txtNombreDos: TextView = itemView.findViewById(R.id.rv_nombre2)
        val txtPuntajeUno: TextView = itemView.findViewById(R.id.rv_puntaje1)
        val txtPuntajeDos: TextView = itemView.findViewById(R.id.rv_puntaje2)
        val txtFecha: TextView = itemView.findViewById(R.id.rv_fecha)
    }

}