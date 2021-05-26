package com.cbellmont.ejercicioandroid8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.cbellmont.ejercicioandroid8.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addListenerToButton()
        addListenerToEditText()
        addListenerToTextView()
    }

    private fun addListenerToTextView() {
        binding.twContent.setOnLongClickListener {
            Toast.makeText(this, "Transformando texto a mayusculas", Toast.LENGTH_LONG).show()
            binding.etContent.setText(binding.etContent.text.toString().uppercase(Locale.getDefault()))
            true
        }
    }

    private fun addListenerToButton() {
        binding.bConvert.setOnClickListener {
            if(binding.twContent.text.isEmpty())
                Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Hay ${binding.twContent.text.length} caracteres escritos", Toast.LENGTH_LONG).show()
        }
    }


    private fun addListenerToEditText() {
        binding.etContent.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.twContent.text = binding.etContent.text
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

    }
}