package com.example.miprimerappandroid

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.miprimerappandroid.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity()
{
    val miTag:String = "UdelP"
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
///        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(miTag, "Estoy en onCreate - HOME")

        binding.btnAceptar.setOnClickListener {
            val i = Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra("id", 23)
                putExtra("nombre", "Samuel")
            }
            startActivity(i)

        }

        binding.btnToast.setOnClickListener {
            Toast.makeText(this@MainActivity, "Esto es un ejemplo de TOAST ", Toast.LENGTH_LONG)
                .show()
        }

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "Esto es un ejemplo de SNACKBAR", Snackbar.LENGTH_LONG).show()
        }

        binding.btnDialog.setOnClickListener {
            miDialogo().show()
        }

        binding.btnIntent.setOnClickListener {
            val i = Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtra("id", 23)
                putExtra("name", "Samuel")
            }
            startActivity(i)
        }

        binding.fabMiBoton.setOnClickListener {

        Toast.makeText(this@MainActivity, "Es un boton flotante", Toast.LENGTH_SHORT).show()

    }
    }

    private fun miDialogo():AlertDialog
    {
        val miAlerta = AlertDialog.Builder(this@MainActivity)
        miAlerta.setTitle("Titulo del dialogo")
        miAlerta.setMessage("Mensaje del dialogo")
        miAlerta.setPositiveButton("SI"){_,_ ->
            Toast.makeText(this@MainActivity,"Click en SI ",Toast.LENGTH_SHORT).show()
        }
        miAlerta.setNegativeButton("NO"){_,_ ->
            Toast.makeText(this@MainActivity,"Click en NO ",Toast.LENGTH_SHORT).show()
        }

        return miAlerta.create()
    }

    override fun onStart()
    {
        super.onStart()
        Log.d(miTag, "Estoy en onStart - HOME")
    }

    override fun onResume()
    {
        super.onResume()
        Log.d(miTag, "Estoy en onResume - HOME")
    }

    override fun onPause()
    {
        super.onPause()
        Log.d(miTag, "Estoy en onPause - HOME")
    }

    override fun onStop()
    {
        super.onStop()
        Log.d(miTag, "Estoy en onStop - HOME")
    }
    override fun onRestart()
    {
        super.onRestart()
        Log.d(miTag, "Estoy en onRestart - HOME")
    }

    override fun onDestroy()
    {
        super.onDestroy()
        Log.d(miTag, "Estoy en onDestroy - HOME")
    }
}