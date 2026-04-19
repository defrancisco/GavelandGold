package com.example.gavelandgold

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuctionDetailPlushActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Establecer el layout
        setContentView(R.layout.activity_auction_detail_plush)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Botón Flecha Izquierda: Va al Reloj de Totoro
        val btnNextItem = findViewById<TextView>(R.id.btnNextItem)
        btnNextItem.setOnClickListener {
            val intent = Intent(this, AuctionDetailActivity::class.java)
            startActivity(intent)
        }

        // --- LÓGICA DE LA BARRA DE NAVEGACIÓN ---

        // Buscamos los botones por su ID (Asegurate de que estos IDs coincidan con tu component_bottom_nav.xml)
        val navInicio = findViewById<View>(R.id.navInicio)
        val navSubastas = findViewById<View>(R.id.navSubastas)
        val navCuenta = findViewById<View>(R.id.navCuenta)

        // 1. Botón Inicio -> Va a la lista principal (AuctionListActivity)
        navInicio.setOnClickListener {
            val intent = Intent(this, AuctionListActivity::class.java)
            // Limpiamos el historial para que no se acumulen pantallas infinitamente
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // 2. Botón Subastas -> Mis pujas activas (Como no está, mostramos un mensajito)
        navSubastas.setOnClickListener {
            android.widget.Toast.makeText(this, "Mis pujas activas: ¡Próximamente!", android.widget.Toast.LENGTH_SHORT).show()
        }

        // 3. Botón Cuenta -> Va a Mi Perfil (ProfileActivity)
        navCuenta.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            // finish() opcional acá si no querés que puedan volver atrás con la flecha del celular
        }
    }
}