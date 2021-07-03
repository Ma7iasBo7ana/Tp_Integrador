package com.example.tp_integrador_final.dto

import java.io.Serializable

data class PacienteInformacion (val comidadiaria: String, val comidaprincipal:String, val comidasecundaria: String, val bebida:String,val postre: String, val postretentacion:String, val comidahambre:String, val id: Int=0):
    Serializable