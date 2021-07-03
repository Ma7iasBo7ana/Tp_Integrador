package com.example.tp_integrador_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_integrador_final.dao.DBHelper
import com.example.tp_integrador_final.dto.Paciente

lateinit var nombre: EditText
lateinit var dni: EditText
lateinit var guardar:Button
lateinit var ver:Button
lateinit var PacienteReciclado: RecyclerView
lateinit var apellido: EditText
lateinit var fecha: EditText
lateinit var tratamiento: EditText
lateinit var contraseña: EditText
lateinit var sexo: EditText
lateinit var localidad: EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        inicializar()

        val db: DBHelper = DBHelper(this,null)
        guardar.setOnClickListener(View.OnClickListener {
            if (db.savePaciente(Paciente(nombre.text.toString(),apellido.text.toString(),dni.text.toString().toInt(),sexo.text.toString(),fecha.text.toString().toInt(),localidad.text.toString(),contraseña.text.toString(),tratamiento.text.toString())))
            {

                Toast.makeText(it.context,"Paciente Guardado", Toast.LENGTH_LONG).show()

            }
            else{
                Toast.makeText(it.context,"Ver log de errores", Toast.LENGTH_LONG).show()
            }

        })

    }
    private fun inicializar(){
        nombre= findViewById(R.id.t_nombre)
        dni=findViewById(R.id.t_dni)
        guardar=findViewById(R.id.b_guardar)
        apellido= findViewById(R.id.t_apellido)
        sexo= findViewById(R.id.t_sexo)
        fecha= findViewById(R.id.t_fecha)
        localidad= findViewById(R.id.t_localidad)
        contraseña= findViewById(R.id.t_contraseña)
        tratamiento= findViewById(R.id.t_tratamiento)
    }
}