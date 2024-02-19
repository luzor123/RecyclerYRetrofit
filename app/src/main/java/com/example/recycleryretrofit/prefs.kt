package com.example.recycleryretrofit

import android.content.Context

class prefs(val context:Context) {

    val SHARED_NAME = "Mydtb"
    val SHARED_USER_NAME = "username"
    val SHARED_USER_EMAIL = "useremail"
    val SHARED_USER_CONTRASEÑA = "usercontraseña"
    val SHARED_USER_PREMIUM = "premium"
    val SHARED_USER_NOCTURNO = "nocturno"


    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun guardarNombre(name: String) {
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun guardarEmail(name: String) {
        storage.edit().putString(SHARED_USER_EMAIL, name).apply()
    }

    fun guardarContraseña(name: String) {
        storage.edit().putString(SHARED_USER_CONTRASEÑA, name).apply()
    }

    fun guardarPremium(premium: Boolean) {
        storage.edit().putBoolean(SHARED_USER_PREMIUM, premium).apply()
    }
    fun guardarNocturno(nocturno: Boolean) {
        storage.edit().putBoolean(SHARED_USER_NOCTURNO, nocturno).apply()
    }

    fun getNombre(): String {
        return storage.getString(SHARED_USER_NAME, "")!!
    }
    fun getEmail(): String {
        return storage.getString(SHARED_USER_EMAIL, "")!!
    }
    fun getContraseña(): String{
        return storage.getString(SHARED_USER_CONTRASEÑA,"")!!
    }
    fun getPremium(): Boolean{
        return storage.getBoolean(SHARED_USER_PREMIUM, false)
    }
    fun getNocturno(): Boolean{
        return storage.getBoolean(SHARED_USER_NOCTURNO, false)
    }

}