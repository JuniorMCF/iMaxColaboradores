package com.imaxcolaboradores.app.features.Entrega

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.fragments.DetalleSolicitudFinal
import kotlinx.android.synthetic.main.activity_entrega_realizada.*

class EntregaRealizadaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrega_realizada)


        btnEntregado.setOnClickListener{
            supportFragmentManager.beginTransaction().add(R.id.contenedor_detalle_final,DetalleSolicitudFinal(),"detalle_solicitud_final").commit()
        }
    }
}
