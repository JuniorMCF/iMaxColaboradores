package com.imaxcolaboradores.app.features.Principal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.imaxcolaboradores.app.R
import com.imaxcolaboradores.app.features.Principal.fragments.activoFragment
import com.imaxcolaboradores.app.features.Principal.fragments.informesFragment
import com.imaxcolaboradores.app.features.Principal.fragments.perfilFragment
import com.imaxcolaboradores.app.features.Principal.fragments.solicitudesFragment

class primerbottonviewActivity : AppCompatActivity() {


    lateinit var activadofragment : activoFragment
    lateinit var solisitudesgrafment : solicitudesFragment
    lateinit var informesfragment : informesFragment
    lateinit var perfinfragment : perfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primerbottonview)

        val bottomNavigationView : BottomNavigationView = findViewById(R.id.btm_nav1)

        //boton por defautl
        activadofragment = activoFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layaout, activadofragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.Activado ->{
                    activadofragment =
                        activoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, activadofragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.Solicitudes ->{
                    solisitudesgrafment =
                        solicitudesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, solisitudesgrafment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.Informes ->{
                    informesfragment =
                        informesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, informesfragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.Perfil ->{
                    perfinfragment =
                        perfilFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layaout, perfinfragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }


            }
            true
        }
    }
}
