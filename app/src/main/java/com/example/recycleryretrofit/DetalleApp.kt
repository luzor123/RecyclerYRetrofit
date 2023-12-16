package com.example.recycleryretrofit

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class DetalleApp :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalleapp)
        title="detalles de la App"
        val nombre= intent.getStringExtra("nombre")
        val textViewNombre: TextView = findViewById(R.id.idnombred)
        textViewNombre.text= nombre

        val descripcion= intent.getStringExtra("Descripcion")
        val textViewDescripcion: TextView = findViewById(R.id.iddescripciond)
        textViewDescripcion.text= descripcion

        val autorizacion= intent.getStringExtra("autorización")
        val textViewAutorizacion: TextView = findViewById(R.id.idauthd)
        textViewAutorizacion.text= autorizacion


        val cors= intent.getStringExtra("Cors")
        val textViewCors: TextView = findViewById(R.id.idcorsd)
        textViewCors.text= "Cors? $cors"

        val categoria= intent.getStringExtra("Categoria")
        val textViewCategoria: TextView = findViewById(R.id.idcategoryd)
        textViewCategoria.text= categoria


    }
}
