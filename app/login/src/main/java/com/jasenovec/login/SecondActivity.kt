package com.jasenovec.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.jasenovec.login.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    //1. Declaramos la variable binding

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //2. Inicializar el binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //3. obtenemos el valor username
        val username = intent.getStringExtra("username")

        //4. mostramos el mensaje de bienvenida
        binding.tvWelcome.text = "Bienvenido $username"

        //5. Configuramos el botón
        binding.btLogout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}