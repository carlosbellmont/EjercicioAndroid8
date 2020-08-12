package com.cbellmont.ejercicioandroid8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListenerToButton()
        addListenerToEditText()
        addListenerToTextView()
    }

    private fun addListenerToTextView() {
        twContent.setOnLongClickListener {
            Toast.makeText(this, "Transformando texto a mayusculas", Toast.LENGTH_LONG).show()
            etContent.setText(etContent.text.toString().toUpperCase(Locale.getDefault()))
            true
        }
    }

    private fun addListenerToButton() {
        bConvert.setOnClickListener {
            if(twContent.text.isEmpty())
                Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Hay ${twContent.text.length} caracteres escritos", Toast.LENGTH_LONG).show()
        }
    }


    private fun addListenerToEditText() {
        etContent.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                twContent.text = etContent.text
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

    }
}