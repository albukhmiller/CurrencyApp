package bukhmiller.alex.currencyapp.presentations.presenters

import bukhmiller.alex.currencyapp.presentations.views.CorrencyView

/**
 * Created by alex on 09.07.2018.
 */
interface CorrencyPresenter : BaseMvpPresenter<CorrencyView> {


    fun loadCurrencies()

    fun startUploadCircle()

}