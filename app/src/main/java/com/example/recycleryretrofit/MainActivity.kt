package com.example.recycleryretrofit

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleryretrofit.databinding.MainBinding
import com.example.recycleryretrofit.ui.theme.RecyclerYRetrofitTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.SSLSessionBindingEvent

class MainActivity : AppCompatActivity(), OnQueryTextListener, SearchView.OnQueryTextListener {
    private lateinit var binding: MainBinding
    private lateinit var adapter: appAdapter
    private var app= mutableListOf<Entry>()
    private var pasa=true
    private lateinit var prefs: prefs


    override fun onCreate(savedInstanceState: Bundle?){
        val splash= installSplashScreen()
        super.onCreate(savedInstanceState)
        binding=MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svApps.setOnQueryTextListener(this)
        initRecyclerView()
        showAllEntries()

        splash.setKeepOnScreenCondition{ pasa}

    }
    private fun nocturno(){
        val colorNegro = ContextCompat.getColor(this, R.color.black)
        if(prefs.getNocturno())
        {
            binding.root.setBackgroundColor(colorNegro)
        }
    }
    private  fun initRecyclerView(){
        adapter= appAdapter(app)
        binding.reciclador.layoutManager=LinearLayoutManager(this)
        binding.reciclador.adapter=adapter

    }
    private fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.publicapis.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    private fun showAllEntries() {
        // Llama a la función de búsqueda sin especificar una categoría para obtener todas las entradas
        searchByCategories("")
        pasa=false
    }
    private  fun searchByCategories(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call=getRetrofit().create(APIService::class.java).getEntriesByCategory("entries?Category=$query")
            val appis=call.body()
            runOnUiThread{
                if(call.isSuccessful){
                    val entrada=appis?.entries ?: emptyList()
                    app.clear()
                    app.addAll(entrada)
                    adapter.notifyDataSetChanged()

                }else{
                    showError()
                }
            }

        }
    }
    private  fun showError(){
        Toast.makeText(this,"ha ocurrrido un error",Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByCategories(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}