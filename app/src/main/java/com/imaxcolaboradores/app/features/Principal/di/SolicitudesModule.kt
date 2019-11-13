package com.imaxcolaboradores.app.features.Principal.di

import com.imaxcolaboradores.app.features.Principal.Adapters.DisponiblesAdapter
import com.imaxcolaboradores.app.features.Principal.Adapters.HistorialAdapter
import com.imaxcolaboradores.app.features.Principal.Adapters.InformeIngresoAdapter
import com.imaxcolaboradores.app.features.Principal.Adapters.PendientesAdapter
import com.imaxcolaboradores.app.features.Principal.PrincipalViewModel
import com.imaxcolaboradores.app.features.Principal.primerbottonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val solitudesModule = module {
    viewModel { PrincipalViewModel() }
    factory { DisponiblesAdapter()}
    factory {HistorialAdapter()}
    factory { PendientesAdapter() }
    viewModel { primerbottonViewModel() }
    factory { InformeIngresoAdapter() }

}