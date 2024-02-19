package com.example.recycleryretrofit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.ComponentActivity

class login : ComponentActivity(){

    lateinit var botonRegistro: Button
    lateinit var etNombre: EditText
    lateinit var etemail: EditText
    lateinit var etContraseña: EditText
    lateinit var cbPremium: CheckBox
    lateinit var prefe: prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        prefe = preferencesApplication.prefe
        botonRegistro = findViewById(R.id.btRegistro)
        etNombre = findViewById(R.id.etNombre)
        etemail = findViewById(R.id.etEmail)
        etContraseña = findViewById(R.id.etContraseña)
        cbPremium = findViewById(R.id.cbPremium)
        initUI()
        ComprobarValores()
    }
    fun ComprobarValores(){
        if(prefe.getNombre().isNotEmpty()and prefe.getContraseña().isNotEmpty() and prefe.getEmail().isNotEmpty()){
            goToPrincipal()
        }
    }
    private fun initUI() {

        botonRegistro.setOnClickListener { accesToDetail() }
    }

    private fun accesToDetail() {
        if (etNombre.text.toString().isNotEmpty() && etemail.text.toString().isNotEmpty() && etContraseña.text.toString().isNotEmpty()) {
            prefe.guardarNombre(etNombre.text.toString())
            prefe.guardarContraseña(etContraseña.text.toString())
            prefe.guardarEmail(etemail.text.toString())
            prefe.guardarPremium(cbPremium.isChecked)
        } else {

        }
        goToPrincipal()
    }

    private fun goToPrincipal() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}



