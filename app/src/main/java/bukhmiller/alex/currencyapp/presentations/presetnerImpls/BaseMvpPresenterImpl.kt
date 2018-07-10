package bukhmiller.alex.currencyapp.presentations.presetnerImpls

import bukhmiller.alex.currencyapp.presentations.presenters.BaseMvpPresenter
import bukhmiller.alex.currencyapp.presentations.views.BaseMvpView

/**
 * Created by alex on 09.07.2018.
 */
abstract class BaseMvpPresenterImpl<V : BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView: V? = null

    override fun attachView(mvpView: V) {
        mView = mvpView
    }

    override fun detachView() {
        mView = null
    }
}