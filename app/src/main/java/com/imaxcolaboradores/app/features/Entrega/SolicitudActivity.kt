package com.imaxcolaboradores.app.features.Entrega


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.GoogleMap
import com.google.firebase.firestore.FirebaseFirestore
import com.imaxclientes.app.models.PedidoAgencia
import com.imaxclientes.app.models.PedidoCargo
import com.imaxclientes.app.models.PedidoDomicilio
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio.DomicilioAceptarFragment
import com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio.DomicilioEntregarFragment
import com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio.DomicilioRealizadoFragment
import com.imaxcolaboradores.app.features.Entrega.fragments.Domicilio.DomicilioRecogerFragment

import com.imaxcolaboradores.app.models.SolicitudesDisponibles


class SolicitudActivity : AppCompatActivity() {

    private lateinit var mMap: GoogleMap
    lateinit var solicitud:SolicitudesDisponibles
    private lateinit var pedidoAgencia: PedidoAgencia
    private lateinit var pedidoCargo: PedidoCargo
    private lateinit var pedidoDomicilio: PedidoDomicilio
    var database:FirebaseFirestore?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrega_disponible)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        val bundle = intent.getBundleExtra("bundle")

        database =  FirebaseFirestore.getInstance()


        solicitud = bundle.getSerializable("pedidoDisponible")  as SolicitudesDisponibles


        Log.d("aca","solicitud $solicitud")

        //-------TIPOS DE PEDIDOS----------
        if(solicitud.tipo=="DOMICILIO"){
            pedidoDomicilio = solicitud.data!! as PedidoDomicilio
            if(pedidoDomicilio.estadoServicio == "0"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioAceptarFragment(),"domicilio_aceptar").commitAllowingStateLoss()
            }else if(pedidoDomicilio.estadoServicio == "1"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
            }else if(pedidoDomicilio.estadoServicio == "2"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioEntregarFragment(),"domicilio_entregar").commitAllowingStateLoss()
            }else if(pedidoDomicilio.estadoServicio == "3" || pedidoDomicilio.estadoServicio == "4" || pedidoDomicilio.estadoServicio == "5"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRealizadoFragment(),"domicilio_realizado").commitAllowingStateLoss()
            }


        }else if(solicitud.tipo=="AGENCIA LIMA"){
            pedidoAgencia = solicitud.data!! as PedidoAgencia
            if(pedidoAgencia.estadoServicio == "0"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioAceptarFragment(),"domicilio_aceptar").commitAllowingStateLoss()
            }else if(pedidoAgencia.estadoServicio == "1"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
            }else if(pedidoAgencia.estadoServicio == "2"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioEntregarFragment(),"domicilio_entregar").commitAllowingStateLoss()
            }else if(pedidoAgencia.estadoServicio == "3" || pedidoAgencia.estadoServicio == "4" || pedidoAgencia.estadoServicio == "5"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRealizadoFragment(),"domicilio_realizado").commitAllowingStateLoss()
            }

        }else if(solicitud.tipo=="CON RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo
            if(pedidoCargo.estadoServicio == "0"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioAceptarFragment(),"domicilio_aceptar").commitAllowingStateLoss()
            }else if(pedidoCargo.estadoServicio == "1"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
            }else if(pedidoCargo.estadoServicio == "2"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioEntregarFragment(),"domicilio_entregar").commitAllowingStateLoss()
            }else if(pedidoCargo.estadoServicio == "3" || pedidoCargo.estadoServicio == "4" || pedidoCargo.estadoServicio == "5"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRealizadoFragment(),"domicilio_realizado").commitAllowingStateLoss()
            }

        }else if(solicitud.tipo=="SIN RECOJO"){
            pedidoCargo = solicitud.data!! as PedidoCargo
            if(pedidoCargo.estadoServicio == "0"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioAceptarFragment(),"domicilio_aceptar").commitAllowingStateLoss()
            }else if(pedidoCargo.estadoServicio == "1"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRecogerFragment(),"domicilio_recoger").commitAllowingStateLoss()
            }else if(pedidoCargo.estadoServicio == "2"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioEntregarFragment(),"domicilio_entregar").commitAllowingStateLoss()
            }else if(pedidoCargo.estadoServicio == "3" || pedidoCargo.estadoServicio == "4" || pedidoCargo.estadoServicio == "5"){
                supportFragmentManager.beginTransaction().replace(R.id.fl_solicitud,
                    DomicilioRealizadoFragment(),"domicilio_realizado").commitAllowingStateLoss()
            }

        }


    }


}
