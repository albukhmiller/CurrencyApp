package bukhmiller.alex.currencyapp.presentations.presetnerImpls

import bukhmiller.alex.currencyapp.domain.InteractorListener
import bukhmiller.alex.currencyapp.domain.LoaderCurrenciesInteractor
import bukhmiller.alex.currencyapp.model.Corrency
import bukhmiller.alex.currencyapp.presentations.presenters.CorrencyPresenter
import bukhmiller.alex.currencyapp.presentations.views.CorrencyView
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class CurrencyPresetnerImpl @Inject constructor(private val loaderCurrenciesInteractor: LoaderCurrenciesInteractor) : BaseMvpPresenterImpl<CorrencyView>(), CorrencyPresenter, InteractorListener {

    init {
        loaderCurrenciesInteractor.setListener(this)
    }

    override fun loadCurrencies() {
        mView?.showProgressBar()
        loaderCurrenciesInteractor.loadCurrencies()
    }

    override fun startUploadCircle() {
        Timer().schedule(loaderCurrenciesInteractor, 0, 15000)
    }

    override fun uploadCurrencies() {
        mView?.showProgressBar()
        loaderCurrenciesInteractor.loadCurrencies()
    }

    override fun <T> onSuccessLoad(data: T) {
            mView?.onSuccessLoadCurrencies(data as ArrayList<Corrency>)
    }

    override fun onFailure() {
        mView?.onFailureLoadCurrencies()
    }

}