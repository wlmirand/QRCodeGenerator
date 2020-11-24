package miranda.william.qrcodegenerator

import android.app.Application
import miranda.william.qrcodegenerator.di.dbModule
import miranda.william.qrcodegenerator.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 */
class SignatureApplication : Application() {

    /**
     * OnCreate
     */
    override fun onCreate() {
        super.onCreate()

        //Initialize Koin for Dependency Injection
        startKoin {
            androidContext(this@SignatureApplication)
            modules(
                dbModule,
                viewModelModule
            )
        }
    }

}