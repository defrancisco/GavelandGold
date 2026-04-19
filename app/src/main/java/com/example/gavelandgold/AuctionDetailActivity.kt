package com.example.gavelandgold

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuctionDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auction_detail)

        // Botón Subastas: Cierra el detalle y vuelve a la lista
        val navSubastas = findViewById<TextView>(R.id.navSubastas)
        navSubastas.setOnClickListener {
            finish()
        }

        // Botón Flecha Derecha: Va al Peluche de Totoro
        val btnNextItem = findViewById<TextView>(R.id.btnNextItem)
        btnNextItem.setOnClickListener {
            val intent = Intent(this, AuctionDetailPlushActivity::class.java)
            startActivity(intent)
        }
    }
}