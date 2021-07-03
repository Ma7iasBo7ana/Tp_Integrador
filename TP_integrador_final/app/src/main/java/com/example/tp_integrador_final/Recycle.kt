package com.example.tp_integrador_final

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_integrador_final.adapter.Paciente_adapter
import com.example.tp_integrador_final.dao.DBHelper

class Recycle : AppCompatActivity() {

    lateinit var PacienteReciclado: RecyclerView
    lateinit var mostrarusuarios:Button

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)
        inicializar()
        val db: DBHelper = DBHelper(this,null)
        mostrarusuarios.setOnClickListener(View.OnClickListener {
            val pacienteAdapter: Paciente_adapter = Paciente_adapter(db.getAllPacientes())
            PacienteReciclado.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
            PacienteReciclado.adapter=pacienteAdapter

        })





    }
    private fun inicializar(){
        PacienteReciclado= findViewById(R.id.Recycle)
        mostrarusuarios=findViewById(R.id.b_mostrarusuarios)


    }

}