package com.imaxcolaboradores.app.features.Login.di

import com.imaxcolaboradores.app.features.Login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel()}
}