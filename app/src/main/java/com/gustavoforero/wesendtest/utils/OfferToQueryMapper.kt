package com.gustavoforero.wesendtest.utils

import com.gustavoforero.wesendtest.data.model.QueryBTC
import com.gustavoforero.wesendtest.data.remote.model.DataOffer
import com.gustavoforero.wesendtest.data.remote.model.Offer
import io.reactivex.functions.Function
import java.text.NumberFormat
import java.util.*

object OfferToQueryMapper : Function<List<Offer>?, QueryBTC> {


    override fun apply(t: List<Offer>): QueryBTC {


        val offers = ArrayList<DataOffer>()

        for (offer in t) {
            offers.add(offer.data)
        }

        val values = ArrayList<Double>()

        for (dataOffer in offers) {
            values.add(dataOffer.temp_price_usd.toDouble())
        }
        val numOutliers = getNumOfOutliers(values)
        val rate = getRate(values, numOutliers)
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        return QueryBTC(format.format(rate), numOutliers.size, Date().toString())
    }


    private fun getRate(allNumbers: List<Double>, outliers: List<Double>): Double {
        var sum = 0.0
        for (number in allNumbers) {
            if (!outliers.contains(number))
                sum += number
        }
        return sum / allNumbers.size
    }

    private fun getNumOfOutliers(allNumbers: List<Double>): List<Double> {
        val commonValues = ArrayList<Double>()
        val outliersValues = ArrayList<Double>()

        var sum = 0.0
        for (number in allNumbers) {
            sum += number
        }
        val average = sum / allNumbers.size

        sum = 0.0
        for (number in allNumbers) {
            sum += Math.pow(number - average, 2.0)
        }
        val standardDeviation = Math.sqrt(sum / allNumbers.size)

        for (number in allNumbers) {
            if (Math.abs(number - average) > 2 * standardDeviation) {
                outliersValues.add(number)
            } else {
                commonValues.add(number)
            }
        }

        return outliersValues
    }


}