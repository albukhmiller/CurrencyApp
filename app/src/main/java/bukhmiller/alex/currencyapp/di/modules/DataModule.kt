package bukhmiller.alex.currencyapp.di.modules

import bukhmiller.alex.currencyapp.model.ApiServer
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by alex on 09.07.2018.
 */

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesApiServer(): ApiServer = Retrofit.Builder()
            .baseUrl("http://phisix-api3.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServer::class.java)
}