package bukhmiller.alex.currencyapp.model

/**
 * Created by alex on 09.07.2018.
 */
data class Corrency(var name: String, var price: Price, var volume: Int) {

    data class Stock(var stock: ArrayList<Corrency>)

    data class Price(var amount: Double)
}

