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
import com.example.tp_integrador_final.dto.Paciente

class Paciente_adapter(private val dataset: ArrayList<Paciente>): RecyclerView.Adapter<Paciente_adapter.ViewHolder>() {

    //Mapeamos Paciente_layout
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nombre: EditText
        val dni: EditText
        val id: TextView
        val editar: Button
        val aceptar: Button
        val borrar: Button
        val apellido: EditText
        val fecha: EditText
        val tratamiento: EditText
        val contraseña: EditText
        val localidad: EditText
        val sexo: EditText

        init {
            nombre = view.findViewById(R.id.p_nombre)
            dni = view.findViewById(R.id.p_dni)
            id = view.findViewById(R.id.p_id)
            editar = view.findViewById(R.id.b_i_aceptar)
            aceptar = view.findViewById(R.id.b_i_cancelar)
            borrar = view.findViewById(R.id.b_borrar)
            apellido = view.findViewById(R.id.p_apellido)
            fecha = view.findViewById(R.id.p_fecha)
            tratamiento = view.findViewById(R.id.p_tratamiento)
            contraseña = view.findViewById(R.id.p_contraseña)
            localidad = view.findViewById(R.id.p_localidad)
            sexo = view.findViewById(R.id.p_sexo)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.paciente_layout,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.setText(dataset[position].nombre)
        holder.dni.setText(dataset[position].dni.toString())
        holder.id.setText(dataset[position].id.toString())
        holder.apellido.setText(dataset[position].apellido)
        holder.tratamiento.setText(dataset[position].tratamiento)
        holder.contraseña.setText(dataset[position].contraseña)
        holder.localidad.setText(dataset[position].localidad)
        holder.fecha.setText(dataset[position].fecha.toString())
        holder.sexo.setText(dataset[position].sexo)

        //editar

        holder.editar.setOnClickListener(View.OnClickListener {
            Toast.makeText(it.context,dataset[position].nombre+ "editado", Toast.LENGTH_LONG).show()
        })


    }

}