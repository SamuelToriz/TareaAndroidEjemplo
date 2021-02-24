package com.example.miprimerappandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.miprimerappandroid.databinding.ActivityMainBinding
import com.example.miprimerappandroid.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySecondBinding
    val miTag:String = "UdelP"
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
///        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id:Int = intent.getIntExtra("id", 0)
        val nombre:String? = intent.getStringExtra("name")

        Toast.makeText(this@SecondActivity, "$id $nombre", Toast.LENGTH_SHORT).show()


        ///abre url en el navegador
        binding.btnUrl.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse("http://www.google.com") }
            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@SecondActivity, "No hay navegador", Toast.LENGTH_SHORT).show()
            }
        }

        //&q es la ubicacion del pin
        // z significa el zoom 26 es el maximo
        //geo es la localizacion
        binding.btnMapa.setOnClickListener {
            ///Action View nos abre la app
            var intent = Intent(Intent.ACTION_VIEW).apply { data= Uri.parse("geo:19.28958619366017,-99.13938537622406?z=18 &q=19.28958619366017,-99.13938537622406") }
            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@SecondActivity, "No hay aplicacion de mapa", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnLlamada.setOnClickListener {
            ///action call es para hacer la llamada directa y action dial nos muestra el numero
            var intent = Intent(Intent.ACTION_DIAL).apply { data= Uri.parse("tel:5611593808") }
            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@SecondActivity, "No hay aplicacion de mapa", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnEmail.setOnClickListener {

            val email = arrayOf("saamm0830@gmail.com")
            var intent = Intent(Intent.ACTION_SEND).apply {

                type = "text/plain"
                ///putExtra es una collecion de llaves y datos
                putExtra(Intent.EXTRA_EMAIL, email)
                putExtra(Intent.EXTRA_SUBJECT, "Correo de prueba")
                putExtra(Intent.EXTRA_TEXT, "Prueba Correo enviado desde la app movil")
            }

            if(intent.resolveActivity(packageManager)!=null) {
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@SecondActivity, "No hay aplicacion de mapa", Toast.LENGTH_SHORT).show()
            }
        }

    }

}