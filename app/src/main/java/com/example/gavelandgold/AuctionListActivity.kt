package com.example.gavelandgold

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class AuctionListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auction_list)

        // Al tocar el ítem de Totoro, vamos al detalle
        val itemTotoro = findViewById<LinearLayout>(R.id.itemTotoro)
        itemTotoro.setOnClickListener {
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