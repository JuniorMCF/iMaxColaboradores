package com.imaxcolaboradores.app.features.Entrega

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imaxcolaboradores.app.R
import kotlinx.android.synthetic.main.activity_entrega_recoger.*

class EntregaRecogerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrega_recoger)

        btnLlegueRecoger.setOnClickListener{
            val intent = Intent(this,EntregaRealizadaActivity::class.java)
            startActivity(intent)
        }
    }
}
