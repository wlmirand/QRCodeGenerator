package miranda.william.qrcodegenerator.di

import miranda.william.qrcodegenerator.ui.home.HomeViewModel
import miranda.william.qrcodegenerator.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin Module for ViewModels
 */
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
}
