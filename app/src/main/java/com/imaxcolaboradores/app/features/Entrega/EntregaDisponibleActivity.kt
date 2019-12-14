package com.imaxcolaboradores.app.features.Entrega

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.imaxclientes.app.models.PedidoAgencia
import com.imaxclientes.app.models.PedidoCargo
import com.imaxclientes.app.models.PedidoDomicilio
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.models.Pedido
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import kotlinx.android.synthetic.main.activity_entrega_disponible.*
import kotlinx.android.synthetic.main.activity_entrega_disponible.txtDirEntregarEn
import kotlinx.android.synthetic.main.activity_entrega_disponible.txtDirRecogerEn
import kotlinx.android.synthetic.main.activity_entrega_disponible.txtObjeto
import kotlinx.android.synthetic.main.activity_entrega_disponible.txtRefRecogerEn
import kotlinx.android.synthetic.main.fragment_acopiadores_disponible.*
import kotlinx.android.synthetic.main.fragment_agencia_entregue.*

class EntregaDisponibleActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var solicitud:SolicitudesDisponibles
    private lateinit var pedidoAgencia: PedidoAgencia
    private lateinit var pedidoCargo: PedidoCargo
    private lateinit var pedidoDomicilio: PedidoDomicilio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrega_disponible)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapView2) as SupportMapFragment
        mapFragment.getMapAsync(this)

        solicitud = intent.getSerializableExtra("pedidoDisponible") as SolicitudesDisponibles


        //-------TIPOS DE PEDIDOS----------
        if(solicitud.document!!.get("tipoServicio")=="Domicilio"){
            pedidoDomicilio = solicitud.document!!.toObject(PedidoDomicilio::class.java)
            txtDirRecogerEn.text = pedidoDomicilio.recogerEn!!
            txtRefRecogerEn.text = pedidoDomicilio.referenciaRecoger1!!
            txtDirEntregarEn.text = pedidoDomicilio.dejarEn!!
            //txtDomicilio.text = pedidoDomicilio.
            txtDistancia.text = "${pedidoDomicilio.distancia1!!} km"
            txtCosto.text = "S/.${pedidoDomicilio.costoServicio!!}"
            txtObjeto.text = ""

        }else if(solicitud.document!!.get("tipoServicio")=="Agencia Lima"){
            pedidoAgencia = solicitud.document!!.toObject(PedidoAgencia::class.java)
        }else if(solicitud.document!!.get("tipoServicio")=="Con Recojo"){
            pedidoCargo = solicitud.document!!.toObject(PedidoCargo::class.java)
        }


        btnAceptarDisponible.setOnClickListener{
            val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))

            with(builder){
                setTitle(solicitud.tipo)
                setMessage("¿Està seguro de aceptar el pedido?")
                setPositiveButton("Ok") { dialog, which ->
                    dialog.dismiss()

                }
                setNegativeButton("Cancel") { dialog, which ->
                    dialog.dismiss()
                }
                builder.show()
            }
        }




    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
