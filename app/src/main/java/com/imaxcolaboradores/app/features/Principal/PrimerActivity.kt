package com.imaxcolaboradores.app.features.Principal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.Adapters.HistorialAdapter
import com.imaxcolaboradores.app.features.Principal.Adapters.PedidosAdapter
import com.imaxcolaboradores.app.features.Principal.fragments.ActivoFragment
import com.imaxcolaboradores.app.features.Principal.fragments.InformesFragment
import com.imaxcolaboradores.app.features.Principal.fragments.PerfilFragment
import com.imaxcolaboradores.app.features.Principal.fragments.SolicitudesFragment
import com.imaxcolaboradores.app.models.Pedido

class PrimerActivity : AppCompatActivity() {

    var tipoColaborador:String?=null  // 0 : acopiador ( menor a 500m ) , 1: motorizado , 2: conductor (furgon)


    var database:FirebaseFirestore? = null
    var pedidoList = ArrayList<Pedido>()
    var historialList = ArrayList<Pedido>()
    var pendienteList = ArrayList<Pedido>()
    var adapter : PedidosAdapter? = null
    lateinit var activadofragment : ActivoFragment
    lateinit var solisitudesgrafment : SolicitudesFragment
    lateinit var informesfragment : InformesFragment
    lateinit var perfinfragment : PerfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primerbottonview)

        val bottomNavigationView : BottomNavigationView = findViewById(R.id.btm_nav1)
        //llamamos a la funcion de firebase

        database =  FirebaseFirestore.getInstance()

        tipoColaborador = "1"

        //boton por defautlt
        activadofragment = ActivoFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layaout, activadofragment)
            //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.Activado ->{
                    activadofragment =
                        ActivoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, activadofragment)
                        //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.Solicitudes ->{
                    solisitudesgrafment =
                        SolicitudesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, solisitudesgrafment)
                      // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.Informes ->{
                    informesfragment =
                        InformesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, informesfragment)
                       // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.Perfil ->{
                    perfinfragment =
                        PerfilFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, perfinfragment)
                      //  .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }


            }
            true
        }




    }
}
