package com.example.tp_integrador_final

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tp_integrador_final.dao.DBHelper
import com.example.tp_integrador_final.dao.DBHelper.Companion.DATABASE_NAME
import com.example.tp_integrador_final.dao.DBHelper.Companion.DATABASE_VERSION

class MainActivity : AppCompatActivity() {

    lateinit var usuario: EditText
    lateinit var contraseña: EditText
    lateinit var ingresar: Button
    lateinit var registrar: Button
    lateinit var usuariosregistrados: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()
        //DBHelper(context, DATABASE_NAME,null, DATABASE_VERSION)
        //var helper = DBHelper(applicationContext)
        //var db = helper.readableDatabase
        registrar.setOnClickListener(View.OnClickListener {
            val intento: Intent = Intent(this,RegisterActivity::class.java)
            startActivity(intento)


        })

        ingresar.setOnClickListener(View.OnClickListener {
            val intento: Intent = Intent(this,welcome::class.java)
            startActivity(intento)

           /* var args= listOf<String>(usuario.toString(),contraseña.toString()).toTypedArray()
            var rs=db.rawQuery("SELECT * FROM paciente WHERE NOMBRE = ? AND contraseña = ?",args)
            if (rs.moveToNext()) {
                Toast.makeText(applicationContext, "Bienvenido", Toast.LENGTH_SHORT).show()
                val intento: Intent = Intent(this,welcome::class.java)
                startActivity(intento)
            }
            else
                Toast.makeText(applicationContext, "Credenciales invalidas", Toast.LENGTH_SHORT).show()
*/
            /*if (usuario.equals("") || contraseña.equals("")) {
                Toast.makeText(this,"Todos los campos deben estar completados",Toast.LENGTH_LONG).show()
            } else {
                validarCredenciales()
            }*/


        })

        usuariosregistrados.setOnClickListener(View.OnClickListener {
            val intento: Intent = Intent(this,Recycle::class.java)
            startActivity(intento)
        })





    }

    private fun validarCredenciales() {
        TODO("Not yet implemented")

       /* val conexionSQLiteHelper = DataBase(this, "dbpaciente", null, 1)
        val db: SQLiteDatabase = conexionSQLiteHelper.getReadableDatabase()

        val usuariodb = usuario.getText().toString()
        val contraseñadb = contraseña.getText().toString()

        val cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIOS.toString() + " WHERE " + Utilidades.CAMPO_USUARIO.toString() + " = '" + usuario.toString() + "' AND " + Utilidades.CAMPO_CONTRASEÑA.toString() + " = '" + contraseña.toString() + "'", null)
        while (cursor.moveToNext()) {
            dbId = cursor.getInt(0)
            dbUsuario = cursor.getString(1)
            dbNombre = cursor.getString(2)
            dbContraseña = cursor.getString(4)
            if (usuario == dbUsuario && contraseña == dbContraseña) {
                val intent = Intent(this@LogIn, Feed::class.java)
                val bundle = Bundle()
                bundle.putInt("idUsuario", dbId)
                bundle.putString("nombreUsuario", dbUsuario)
                intent.putExtras(bundle)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrecto.", Toast.LENGTH_SHORT).show()
            }
        }*/
    }

    private fun inicializar(){
        usuario= findViewById(R.id.mt_usuario)
        contraseña=findViewById(R.id.mt_password)
        ingresar=findViewById(R.id.b_ingresar)
        registrar=findViewById(R.id.b_resgistrar)
        usuariosregistrados=findViewById(R.id.b_userregister)

    }

}