package bukhmiller.alex.currencyapp.presentations.ui.tableAdapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import bukhmiller.alex.currencyapp.R
import bukhmiller.alex.currencyapp.model.Corrency
import de.codecrafters.tableview.TableDataAdapter
import kotlinx.android.synthetic.main.layout_cell_table.view.*

class CorrencyTableAdapter(context: Context, data: MutableList<Corrency>) : TableDataAdapter<Corrency>(context, data) {

    override fun getCellView(rowIndex: Int, columnIndex: Int, parentView: ViewGroup?): View? {
        var renderedView: View? = null
        if (!data.isEmpty()) {
            var currentItem = getRowData(rowIndex)
            when (columnIndex) {
                0 -> renderedView = renderedCellTable(parentView!!, currentItem.name)
                1 -> renderedView = renderedCellTable(parentView!!, currentItem.volume)
                2 -> renderedView = renderedCellTable(parentView!!, currentItem.price.amount)
            }
        }
        return renderedView
    }

    private fun <T> renderedCellTable(parent: ViewGroup, valCell: T): View {
        var v = layoutInflater.inflate(R.layout.layout_cell_table, parent, false)
        when (valCell) {
            is String -> v.cellTable.text = valCell
            is Int -> v.cellTable.text = valCell.toString()
            is Double -> v.cellTable.text = "%.2f".format(valCell)
        }
        return v
    }
}