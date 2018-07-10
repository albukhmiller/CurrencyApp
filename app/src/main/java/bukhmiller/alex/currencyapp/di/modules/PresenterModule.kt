package bukhmiller.alex.currencyapp.di.modules

import bukhmiller.alex.currencyapp.presentations.presenters.CorrencyPresenter
import bukhmiller.alex.currencyapp.presentations.presetnerImpls.CurrencyPresetnerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by alex on 09.07.2018.
 */

@Module
@Singleton
class PresenterModule {

    @Singleton
    @Provides
    fun providesCorrencyPresenter(presenterImpl: CurrencyPresetnerImpl): CorrencyPresenter = presenterImpl
}