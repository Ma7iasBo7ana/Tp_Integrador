package com.example.tp_integrador_final.dto

import java.io.Serializable

data class Paciente (val nombre: String, val apellido:String, val dni: Int, val sexo:String,val fecha: Int, val localidad:String, val contraseña:String, val tratamiento:String, val id: Int=0):
    Serializable