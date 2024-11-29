package com.jasenovec.primerproyecto

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jasenovec.primerproyecto.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Iniciamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Aplicamos los insets

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var contador=0
        //Configuramos el Listener para el botón utilizando binding
        binding.button.setOnClickListener {
            binding.textView.text="¡Boton Cambiado!"
            contador++
            binding.tvContador.text=contador.toString()
        }



        //Sumamos mas 1 el contador en base al botón contar
        binding.btContador.setOnClickListener {
            contador += 1;
            binding.tvContador.text = contador.toString()
        }

        //Botón de resetear el contador
        binding.btreiniciar.setOnClickListener {
            contador=0
            binding.tvContador.text = "0"

        }


    }
}