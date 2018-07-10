package bukhmiller.alex.currencyapp.domain

/**
 * Created by alex on 09.07.2018.
 */
interface InteractorListener {

    fun <T> onSuccessLoad(data: T)

    fun onFailure()

    fun uploadCurrencies()
}