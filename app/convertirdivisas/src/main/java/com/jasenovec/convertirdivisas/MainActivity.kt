package com.jasenovec.convertirdivisas

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.jasenovec.convertirdivisas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.tipo_divisa,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDivisas.adapter = adapter

        binding.spinnerDivisas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedOption = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        binding.convertir.setOnClickListener {
            val monto = binding.editTextMonto.text.toString().toDoubleOrNull()
            val resultado = when (binding.spinnerDivisas.selectedItem.toString()) {
                "Soles a Dólares" -> monto?.let { it / 3.5 }
                "Dólares a Soles" -> monto?.let { it * 3.5 }
                else -> 0.0
            }
            binding.resultado.text = resultado.toString()
        }
    }
}