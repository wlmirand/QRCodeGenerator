package miranda.william.qrcodegenerator.di

import miranda.william.qrcodegenerator.services.db.AppDatabase
import androidx.room.Room
import org.koin.dsl.module

/**
 * Koin Module for Local Database
 */
private const val DATABASE_NAME = "Signature.db"

val dbModule = module {

    //Room Instance
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    //DAOs
    single { get<AppDatabase>().userDao() }
}