package bukhmiller.alex.currencyapp.presentations.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import bukhmiller.alex.currencyapp.App
import bukhmiller.alex.currencyapp.R
import bukhmiller.alex.currencyapp.model.Corrency
import bukhmiller.alex.currencyapp.presentations.presenters.CorrencyPresenter
import bukhmiller.alex.currencyapp.presentations.ui.tableAdapter.CorrencyTableAdapter
import bukhmiller.alex.currencyapp.presentations.views.CorrencyView
import de.codecrafters.tableview.model.TableColumnWeightModel
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_toolbar.*

class MainActivity : BaseActivity<CorrencyView, CorrencyPresenter>(), CorrencyView {

    private var tableAdapter: CorrencyTableAdapter? = null
    private var currencies = mutableListOf<Corrency>()

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(my_toolbar)

        initTableCurrency()
        presenter.startUploadCircle()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        presenter.loadCurrencies()
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccessLoadCurrencies(data: ArrayList<Corrency>) {
        currencies.clear()
        currencies.addAll(data)
        tableAdapter?.notifyDataSetChanged()
        pbLoader.visibility = View.GONE
    }

    override fun onFailureLoadCurrencies() {
        pbLoader.visibility = View.GONE
        layoutError.visibility = View.VISIBLE
    }

    override fun showProgressBar() {
        runOnUiThread {
            layoutError.visibility = View.GONE
            pbLoader.visibility = View.VISIBLE
        }
    }

    private fun initTableCurrency() {
        var columnModel = TableColumnWeightModel(3)
        columnModel.setColumnWeight(0, 2)
        columnModel.setColumnWeight(1, 1)
        columnModel.setColumnWeight(2, 1)
        tableCorrency.columnModel = columnModel
        tableAdapter = CorrencyTableAdapter(this, currencies)
        tableCorrency.dataAdapter = tableAdapter
        tableCorrency.headerAdapter = SimpleTableHeaderAdapter(this, "Name", "Volume", "Amount")
    }
}
