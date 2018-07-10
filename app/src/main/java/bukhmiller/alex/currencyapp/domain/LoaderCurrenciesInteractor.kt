package bukhmiller.alex.currencyapp.domain

import bukhmiller.alex.currencyapp.model.ApiServer
import bukhmiller.alex.currencyapp.model.Corrency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject


class LoaderCurrenciesInteractor @Inject constructor(private val apiServer: ApiServer) : TimerTask() {

    private var listener: InteractorListener? = null

    override fun run() {
        listener?.uploadCurrencies()
    }

    fun setListener(interactor: InteractorListener) {
        listener = interactor
    }

    fun loadCurrencies() {
        apiServer.getCurrencies()
                .enqueue(object : Callback<Corrency.Stock> {
                    override fun onFailure(call: Call<Corrency.Stock>?, t: Throwable?) {
                        listener?.onFailure()
                    }

                    override fun onResponse(call: Call<Corrency.Stock>?, response: Response<Corrency.Stock>?) {
                        if (response!!.body() != null)
                            listener?.onSuccessLoad(response!!.body()!!.stock)
                    }
                })
    }

}