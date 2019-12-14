package com.imaxcolaboradores.app.features.Principal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imaxcolaboradores.app.models.SolicitudesDisponibles
import com.imaxcolaboradores.app.models.SolicitudesHistorial
import com.imaxcolaboradores.app.models.SolicitudesPendientes

class PrincipalViewModel: ViewModel() {
    val disponibleSuccess = MutableLiveData<Any>()
    val pendienteSuccess = MutableLiveData<Any>()
    val historialSuccess = MutableLiveData<Any>()

    private var disponibleList : MutableList<SolicitudesDisponibles> = ArrayList()
    private var pendienteList: MutableList<SolicitudesPendientes> = ArrayList()
    private var historialList: MutableList<SolicitudesHistorial> = ArrayList()

    fun getDisponibles(){

    }

    fun getPendiente(){
        val pendiente1= SolicitudesPendientes("","Arequipa","10min")
        val pendiente2= SolicitudesPendientes("","San Juan del Lurigancho","3min")
        val pendiente3= SolicitudesPendientes("","Independencia","10min")

        pendienteList.add(pendiente1)
        pendienteList.add(pendiente2)
        pendienteList.add(pendiente3)

        pendienteSuccess.postValue(pendienteList)

    }

    fun getHistorial(){
        val historial1= SolicitudesHistorial("Arequipa","Dpto 69","2 cajas","pendiente")
        val historial2= SolicitudesHistorial("San Juan del Lurigancho","Av Chupetin Trujillo","1 caja","")
        val historial3= SolicitudesHistorial("Independencia","Hidraulica","","")


        historialList.add(historial1)
        historialList.add(historial2)
        historialList.add(historial3)

        historialSuccess.postValue(historialList)

    }

}