package com.example.tp_integrador_final.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_integrador_final.R
import com.example.tp_integrador_final.dto.PacienteInformacion

class Paciente_informacion_adapter(private val dataset: ArrayList<PacienteInformacion>): RecyclerView.Adapter<Paciente_informacion_adapter.ViewHolder>() {

    //Mapeamos Paciente_layout
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val comidadiaria: EditText
        val comidaprincipal: EditText
        val comidasecundaria: EditText
        val bebida: EditText
        val postre: EditText
        val postretentacion: EditText
        val comidahambre: EditText
        val aceptar: Button
        val titulo: TextView



        init {
            comidadiaria = view.findViewById(R.id.t_comidadiaria)
            comidaprincipal = view.findViewById(R.id.t_comidaprincipal)
            comidasecundaria = view.findViewById(R.id.t_comidasecundaria)
            bebida = view.findViewById(R.id.t_bebidainfo)
            postre = view.findViewById(R.id.t_postre)
            postretentacion = view.findViewById(R.id.t_postretentacion)
            comidahambre = view.findViewById(R.id.t_comidahmabre)
            aceptar = view.findViewById(R.id.b_i_aceptar)
            titulo =view.findViewById(R.id.t_info)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.paciente_informacion_layout,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.comidadiaria.setText(dataset[position].comidadiaria)
        holder.comidaprincipal.setText(dataset[position].comidaprincipal)
        holder.comidasecundaria.setText(dataset[position].comidasecundaria)
        holder.bebida.setText(dataset[position].bebida)
        holder.postre.setText(dataset[position].postre)
        holder.postretentacion.setText(dataset[position].postretentacion)
        holder.comidahambre.setText(dataset[position].comidahambre)





        //editar

        holder.aceptar.setOnClickListener(View.OnClickListener {
            Toast.makeText(it.context,dataset[position].id.toString()+ "editado", Toast.LENGTH_LONG).show()
        })


    }

}