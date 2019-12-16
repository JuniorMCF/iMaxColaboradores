package com.imaxcolaboradores.app.features.Principal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.Adapters.PedidosAdapter
import com.imaxcolaboradores.app.features.Principal.fragments.ActivoFragment
import com.imaxcolaboradores.app.features.Principal.fragments.PerfilFragment
import com.imaxcolaboradores.app.features.Principal.fragments.SolicitudesFragment
import com.imaxcolaboradores.app.features.Principal.fragments.InformeEntregaFragment
import com.imaxcolaboradores.app.models.Pedido
import kotlinx.android.synthetic.main.activity_primerbottonview.*

class PrimerActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {

    var tipoColaborador:String?=null  // 0 : acopiador ( menor a 500m ) , 1: motorizado , 2: conductor (furgon)


    var database:FirebaseFirestore? = null
    var pedidoList = ArrayList<Pedido>()
    var historialList = ArrayList<Pedido>()
    var pendienteList = ArrayList<Pedido>()
    var adapter : PedidosAdapter? = null
    private var activadofragment = ActivoFragment()
    private var solicitudesFragment = SolicitudesFragment()
    private var informesfragment =
        InformeEntregaFragment()
    private var perfinfragment = PerfilFragment()
    private var actualFragment = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primerbottonview)

        //llamamos a la funcion de firebase

        database =  FirebaseFirestore.getInstance()

        tipoColaborador = "1"

        //boton por defautlt
        activadofragment = ActivoFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layaout, activadofragment,"activadoFragment")
            //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
        actualFragment = activadofragment

        btm_nav1.setOnNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.Activado ->{

                val fragment = supportFragmentManager.findFragmentByTag("activadoFragment")
                if(fragment != null){
                    if(fragment.isVisible){
                        Log.d("primerActivity","visible")
                    }else{
                        supportFragmentManager.beginTransaction().hide(actualFragment).show(fragment).commit()
                        actualFragment = activadofragment
                    }
                }else{
                    Log.d("primerActivity","nuevo")
                    supportFragmentManager
                        .beginTransaction()
                        .hide(actualFragment)
                        .add(R.id.frame_layaout, activadofragment,"activadoFragment")

                        //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    actualFragment = activadofragment
                }



            }
            R.id.Solicitudes ->{

                val fragment = supportFragmentManager.findFragmentByTag("solicitudFragment")
                if(fragment != null) {
                    if (fragment.isVisible) {
                        Log.d("primerActivity", "visible")
                    } else {
                        supportFragmentManager.beginTransaction().hide(actualFragment)
                            .show(fragment).commit()
                        actualFragment = solicitudesFragment
                    }
                }else{
                    supportFragmentManager
                        .beginTransaction()
                        .hide(actualFragment)
                        .add(R.id.frame_layaout, solicitudesFragment,"solicitudFragment")

                        // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    actualFragment = solicitudesFragment
                }



            }
            R.id.Informes ->{

                val fragment = supportFragmentManager.findFragmentByTag("informesFragment")
                if(fragment != null) {
                    if (fragment.isVisible) {
                        Log.d("primerActivity", "visible")
                    } else {
                        supportFragmentManager.beginTransaction().hide(actualFragment)
                            .show(fragment).commit()
                        actualFragment = informesfragment
                    }
                }else{
                    supportFragmentManager
                        .beginTransaction()
                        .hide(actualFragment)
                        .add(R.id.frame_layaout, informesfragment,"informesFragment")

                        // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    actualFragment = informesfragment
                }


            }
            R.id.Perfil ->{


                val fragment = supportFragmentManager.findFragmentByTag("perfilFragment")
                if(fragment != null) {
                    if (fragment.isVisible) {
                        Log.d("primerActivity", "visible")
                    } else {
                        supportFragmentManager.beginTransaction().hide(actualFragment)
                            .show(fragment).commit()
                        actualFragment = perfinfragment
                    }
                }else{
                    supportFragmentManager
                        .beginTransaction()
                        .hide(actualFragment)
                        .add(R.id.frame_layaout, perfinfragment,"perfilFragment")

                        // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    actualFragment = perfinfragment
                }
                


            }


        }


        return true
    }
}
