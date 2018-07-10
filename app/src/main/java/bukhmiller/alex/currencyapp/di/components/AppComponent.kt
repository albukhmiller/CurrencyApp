package bukhmiller.alex.currencyapp.di.components

import android.app.Application
import bukhmiller.alex.currencyapp.presentations.ui.activities.MainActivity
import bukhmiller.alex.currencyapp.di.modules.AppModule
import bukhmiller.alex.currencyapp.di.modules.DataModule
import bukhmiller.alex.currencyapp.di.modules.PresenterModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by alex on 09.07.2018.
 */

@Singleton
@Component(modules = [(AppModule::class), (PresenterModule::class), (DataModule::class)])
interface AppComponent {

    fun inject(app: Application)
    fun inject(mainActivity: MainActivity)
}
