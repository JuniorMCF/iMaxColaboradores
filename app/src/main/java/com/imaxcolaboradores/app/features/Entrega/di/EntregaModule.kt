package com.imaxcolaboradores.app.features.Entrega.di

import com.imaxcolaboradores.app.features.Entrega.EntregaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val entregaModule = module{
    viewModel { EntregaViewModel() }
}