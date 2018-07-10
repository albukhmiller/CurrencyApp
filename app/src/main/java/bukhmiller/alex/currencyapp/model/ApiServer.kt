package bukhmiller.alex.currencyapp.model

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by alex on 09.07.2018.
 */
interface ApiServer {

    @GET("stocks.json")
    fun getCurrencies(): Call<Corrency.Stock>
}