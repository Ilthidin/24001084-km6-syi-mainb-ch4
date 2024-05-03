package com.example.mainb.di

import android.content.SharedPreferences
import com.example.mainb.data.datasource.auth.AuthDataSource
import com.example.mainb.data.datasource.auth.FirebaseAuthDataSource
import com.example.mainb.data.datasource.cart.CartDataSource
import com.example.mainb.data.datasource.cart.CartDatabaseDataSource
import com.example.mainb.data.datasource.category.CategoryApiDataSource
import com.example.mainb.data.datasource.category.CategoryDataSource
import com.example.mainb.data.datasource.product.ProductApiDataSource
import com.example.mainb.data.datasource.product.ProductDataSource
import com.example.mainb.data.datasource.user.UserDataSource
import com.example.mainb.data.datasource.user.UserPreferenceDataSource
import com.example.mainb.data.repository.CartRepository
import com.example.mainb.data.repository.CartRepositoryImpl
import com.example.mainb.data.repository.CategoryRepository
import com.example.mainb.data.repository.CategoryRepositoryImpl
import com.example.mainb.data.repository.ProductRepository
import com.example.mainb.data.repository.ProductRepositoryImpl
import com.example.mainb.data.repository.UserRepository
import com.example.mainb.data.repository.UserRepositoryImpl
import com.example.mainb.data.source.firebase.FirebaseService
import com.example.mainb.data.source.firebase.FirebaseServiceImpl
import com.example.mainb.data.source.local.database.AppDatabase
import com.example.mainb.data.source.local.database.dao.CartDao
import com.example.mainb.data.source.local.pref.UserPreference
import com.example.mainb.data.source.local.pref.UserPreferenceImpl
import com.example.mainb.data.source.network.services.MainBApiService
import com.example.mainb.presentation.cart.CartViewModel
import com.example.mainb.presentation.checkout.CheckoutViewModel
import com.example.mainb.presentation.detailproduct.DetailProductViewModel
import com.example.mainb.presentation.home.HomeViewModel
import com.example.mainb.presentation.login.LoginViewModel
import com.example.mainb.presentation.profile.ProfileViewModel
import com.example.mainb.presentation.register.RegisterViewModel
import com.example.mainb.utils.SharedPreferenceUtils
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object AppModules {
    private val networkModule =
        module {
            single<MainBApiService> { MainBApiService.invoke() }
        }

    // todo : add firebase module
    private val firebaseModule =
        module {
            single<AuthDataSource> { FirebaseAuthDataSource(get()) }
            single<FirebaseService> { FirebaseServiceImpl() }
        }

    private val localModule =
        module {
            single<AppDatabase> { AppDatabase.createInstance(androidContext()) }
            single<CartDao> { get<AppDatabase>().cartDao() }
            single<SharedPreferences> {
                SharedPreferenceUtils.createPreference(
                    androidContext(),
                    UserPreferenceImpl.PREF_NAME,
                )
            }
            single<UserPreference> { UserPreferenceImpl(get()) }
        }

    private val datasource =
        module {
            single<CartDataSource> { CartDatabaseDataSource(get()) }
            single<CategoryDataSource> { CategoryApiDataSource(get()) }
            single<ProductDataSource> { ProductApiDataSource(get()) }
            single<UserDataSource> { UserPreferenceDataSource(get()) }
        }

    private val repository =
        module {
            single<CartRepository> { CartRepositoryImpl(get()) }
            single<CategoryRepository> { CategoryRepositoryImpl(get()) }
            single<ProductRepository> { ProductRepositoryImpl(get()) }
            single<UserRepository> { UserRepositoryImpl(get()) }
        }

    private val viewModelModule =
        module {
            viewModelOf(::HomeViewModel)
            viewModelOf(::LoginViewModel)
            viewModelOf(::RegisterViewModel)
            viewModelOf(::ProfileViewModel)
            viewModelOf(::CartViewModel)
            viewModelOf(::CheckoutViewModel)
            viewModelOf(::DetailProductViewModel)
            viewModel { params ->
                // assisted injection
                DetailProductViewModel(
                    extras = params.get(),
                    cartRepository = get(),
                )
            }
        }

    val modules =
        listOf(
            networkModule,
            localModule,
            datasource,
            repository,
            firebaseModule,
        )
}
