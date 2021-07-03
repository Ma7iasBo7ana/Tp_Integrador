package com.example.tp_integrador_final.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.tp_integrador_final.dto.Paciente
import java.lang.Exception

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context,DATABASE_NAME,factory,DATABASE_VERSION)
{
    companion object{
        val DATABASE_NAME="dbpaciente.db"
        val DATABASE_VERSION=1
        val TABLE_PACIENTE="paciente"
        val COLUMN_ID="usuario"
        val COLUMN_NOMBRE="nombre"
        val COLUMN_APELLIDO="apellido"
        val COLUMN_DNI="dni"
        val COLUMN_SEXO="sexo"
        val COLUMN_FECHA="fecha"
        val COLUMN_LOCALIDAD="localidad"
        val COLUMN_CONTRASEÑA="contraseña"
        val COLUMN_TRATAMIENTO="tratamiento"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE=("CREATE TABLE "+ TABLE_PACIENTE+ "  (" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NOMBRE + " TEXT," +
                COLUMN_APELLIDO + " TEXT," +
                COLUMN_SEXO + " TEXT," +
                COLUMN_FECHA + " INTEGER," +
                COLUMN_LOCALIDAD + " TEXT," +
                COLUMN_CONTRASEÑA + " TEXT," +
                COLUMN_TRATAMIENTO + " TEXT," +
                COLUMN_DNI+ " INTEGER) ")



        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion!=newVersion){
            db?.execSQL("DROP TABLE IF EXISTS " + TABLE_PACIENTE)
            onCreate(db)

        }
    }
    fun savePaciente(p:Paciente):Boolean
    {
        var guardo: Boolean= false
        try {
            val db =this.writableDatabase
            val values= ContentValues()
            values.put(COLUMN_NOMBRE, p.nombre)
            values.put(COLUMN_APELLIDO, p.apellido)
            values.put(COLUMN_SEXO, p.sexo)
            values.put(COLUMN_FECHA, p.fecha)
            values.put(COLUMN_LOCALIDAD, p.localidad)
            values.put(COLUMN_CONTRASEÑA, p.contraseña)
            values.put(COLUMN_TRATAMIENTO, p.tratamiento)
            values.put(COLUMN_DNI, p.dni)

            db.insert(TABLE_PACIENTE,null,values)
            guardo = true

        }catch (e: Exception){
            Log.e("Error-DATABASE",e.message.toString())
            guardo=false
        }
        return guardo
    }

    fun getAllPacientes():ArrayList<Paciente> {
        val listaPaciente: ArrayList<Paciente> = ArrayList<Paciente>()
        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_PACIENTE
        val cursor: Cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val apellido = cursor.getString(cursor.getColumnIndex(COLUMN_APELLIDO))
                val dni = cursor.getInt(cursor.getColumnIndex(COLUMN_DNI))
                val sexo = cursor.getString(cursor.getColumnIndex(COLUMN_SEXO))
                val fecha = cursor.getInt(cursor.getColumnIndex(COLUMN_FECHA))
                val localidad = cursor.getString(cursor.getColumnIndex(COLUMN_LOCALIDAD))
                val contraseña = cursor.getString(cursor.getColumnIndex(COLUMN_CONTRASEÑA))
                val tratamiento = cursor.getString(cursor.getColumnIndex(COLUMN_TRATAMIENTO))
                listaPaciente.add(Paciente(nombre, apellido, dni, sexo, fecha, localidad, contraseña, tratamiento,id))

            } while (cursor.moveToNext())

        }
        return listaPaciente
    }

    fun getPacienteById(id: Int):Paciente{
        val db=this.readableDatabase
        val query = "SELECT * FROM "+ TABLE_PACIENTE + "WHERE"+ COLUMN_ID + "="+id
        var p: Paciente? =null
        val cursor: Cursor = db.rawQuery(query,null)
        if(cursor.moveToFirst()){

            val id =cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
            val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
            val apellido = cursor.getString(cursor.getColumnIndex(COLUMN_APELLIDO))
            val dni =cursor.getInt(cursor.getColumnIndex(COLUMN_DNI))
            val sexo =cursor.getString(cursor.getColumnIndex(COLUMN_SEXO))
            val fecha =cursor.getInt(cursor.getColumnIndex(COLUMN_FECHA))
            val localidad =cursor.getString(cursor.getColumnIndex(COLUMN_LOCALIDAD))
            val contraseña =cursor.getString(cursor.getColumnIndex(COLUMN_CONTRASEÑA))
            val tratamiento =cursor.getString(cursor.getColumnIndex(COLUMN_TRATAMIENTO))

            p= Paciente(nombre,apellido,dni,sexo,fecha,localidad,contraseña,tratamiento,id)

        }
        return p!!

    }
    fun deletePacienteById(id:Int):Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM" + TABLE_PACIENTE + "WHERE" + COLUMN_ID + "=" + id
        var p: Paciente? = null
        val cursor: Cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {


            db.delete(TABLE_PACIENTE, COLUMN_ID + "=" + id, arrayOf(id.toString()))
            return true
        }
        return false
    }
}