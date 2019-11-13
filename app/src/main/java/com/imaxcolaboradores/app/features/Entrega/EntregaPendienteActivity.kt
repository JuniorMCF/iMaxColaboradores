package com.imaxcolaboradores.app.features.Entrega

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.fragments.RechazoPedidoFragment
import kotlinx.android.synthetic.main.activity_entrega_pendiente.*

class EntregaPendienteActivity : AppCompatActivity(), OnMapReadyCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrega_pendiente)


        imgCancelarPendiente.setOnClickListener{
            Log.d("gaa","xxd")
            supportFragmentManager.beginTransaction().replace(R.id.container_rechazo_pedido,RechazoPedidoFragment(),"rechazo_pendiente_fragment").addToBackStack(null).commit()
        }
        btnAceptarPendiente.setOnClickListener{
            val intent = Intent(this,EntregaRecogerActivity::class.java)
            startActivity(intent)
        }


    }





    override fun onMapReady(p0: GoogleMap?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
