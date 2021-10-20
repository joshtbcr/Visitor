package com.manati.visitor.data

import android.util.Log
import com.manati.visitor.model.TipoUsuario
import com.manati.visitor.model.Usuario

class Usuarios {

        val usuarios = ArrayList<Usuario>()

        fun cargarUsuarios(){
            usuarios.add(Usuario("115540476", "Joshua Torres", TipoUsuario.SEGURIDAD.tipo))
            usuarios.add(Usuario("604140362", "Elian Rocha", TipoUsuario.PROPIETARIO.tipo))
            usuarios.add(Usuario("604110141", "Mónica Zúñiga", TipoUsuario.PROPIETARIO.tipo))
            usuarios.add(Usuario("604110141", "Elizabeth Espinoza", TipoUsuario.SEGURIDAD.tipo))
        }

        fun obtenerUsuarios():ArrayList<Usuario>{
            return this.usuarios
        }

        fun existeUsuario(cedula:String):Usuario?{
            usuarios.forEach{
                //Log.d("myTag", it.toString())
                if(cedula==it.cedula) return it
            }
            return null
        }

}