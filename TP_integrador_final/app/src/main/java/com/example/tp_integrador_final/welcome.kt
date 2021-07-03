package com.example.tp_integrador_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class welcome : AppCompatActivity() {
    lateinit var crear: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        inicializar()

        crear.setOnClickListener(View.OnClickListener {
            val intento: Intent = Intent(this,informationActivity::class.java)
            startActivity(intento)
        })

    }

    private fun inicializar(){
        crear=findViewById(R.id.b_create)

    }
}