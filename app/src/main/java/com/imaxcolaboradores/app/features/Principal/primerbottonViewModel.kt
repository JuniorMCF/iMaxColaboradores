package com.imaxcolaboradores.app.features.Principal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imaxcolaboradores.app.models.InformeIngreso


class primerbottonViewModel: ViewModel() {
    val informeentregaSuccess = MutableLiveData<Any>()

    private var informeList : MutableList<InformeIngreso> = ArrayList()
    fun getInforme(){
        val informe1= InformeIngreso("6","JUL", "34.0","66.0","78.0","78.0")
        val informe2= InformeIngreso("7","AGO", "435.0","678.0","890.0","788.0")
        val informe3= InformeIngreso("11","NOV", "567.0","7.0","098.0","890.0")

        informeList.add(informe1)
        informeList.add(informe2)
        informeList.add(informe3)

        informeentregaSuccess.postValue(informeList)

    }
}