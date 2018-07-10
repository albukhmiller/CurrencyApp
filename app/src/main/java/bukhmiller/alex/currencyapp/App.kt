package bukhmiller.alex.currencyapp

import android.app.Application
import bukhmiller.alex.currencyapp.di.components.AppComponent
import bukhmiller.alex.currencyapp.di.components.DaggerAppComponent
import bukhmiller.alex.currencyapp.di.modules.AppModule

/**
 * Created by alex on 09.07.2018.
 */
class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        component.inject(this)
    }
}