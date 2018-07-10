package bukhmiller.alex.currencyapp.presentations.views

import bukhmiller.alex.currencyapp.model.Corrency
import kotlin.collections.ArrayList

/**
 * Created by alex on 09.07.2018.
 */
interface CorrencyView : BaseMvpView {

    fun onSuccessLoadCurrencies(correncies: ArrayList<Corrency>)

    fun onFailureLoadCurrencies()

    fun showProgressBar()
}