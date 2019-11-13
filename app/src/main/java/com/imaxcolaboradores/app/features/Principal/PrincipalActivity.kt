package com.imaxcolaboradores.app.features.Principal

import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import com.imaxcolaboradores.app.R

import org.koin.androidx.viewmodel.ext.android.viewModel

class PrincipalActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    //view model
    private val principalViewModel : PrincipalViewModel by viewModel()
    //viewpager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_principal)
       // val toolbar: Toolbar = findViewById(R.id.toolbar)
       // setSupportActionBar(toolbar)

        /* val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        */

        //CONTENIDO
        /*val fragment = SolicitudesDisponibleFragment()
        supportFragmentManager.beginTransaction().add(R.id.container_fragment_solicitudes,fragment,"SolicitudesDisponibleFragment").addToBackStack(null).commit()
        */

        setBottomMenuBar()
        //setObservers()










    }

    fun setBottomMenuBar(){

    }


    private fun setObservers() {
        principalViewModel.apply {

        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.solicitudes, menu)
        return true
    }

    /*
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    */
}
