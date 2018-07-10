package bukhmiller.alex.currencyapp.presentations.presenters

import bukhmiller.alex.currencyapp.presentations.views.BaseMvpView

interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(mvpView: V)

    fun detachView()
}