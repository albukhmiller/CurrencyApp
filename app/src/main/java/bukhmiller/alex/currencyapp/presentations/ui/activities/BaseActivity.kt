package bukhmiller.alex.currencyapp.presentations.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bukhmiller.alex.currencyapp.presentations.presenters.BaseMvpPresenter
import bukhmiller.alex.currencyapp.presentations.views.BaseMvpView
import javax.inject.Inject


abstract class BaseActivity<in V : BaseMvpView, P : BaseMvpPresenter<V>> : AppCompatActivity() {


    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}