package com.atlantic.city.clientes.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.imaxcolaboradores.app.R

class BottomBar(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var onClickBottomBar : OnClickBottomBar? = null

    init {
        initView()
    }

    private fun initView(){
        inflate(context, R.layout.bottom_bar, this)
        setOnClick()
    }

    private fun setOnClick(){
     /*   newsTab.setOnClickListener {
            onClickBottomBar?.onClickNews()
        }

        paymentTab.setOnClickListener {
            onClickBottomBar?.onClickCharge()
        }

        moreTab.setOnClickListener {
            onClickBottomBar?.onClickMore()
        }
        eventsTab.setOnClickListener {
            onClickBottomBar?.onClickEvent()
        }
        clubTab.setOnClickListener {
            onClickBottomBar?.onClickClub()
        }*/
    }

    interface OnClickBottomBar {
        fun onClickNews()
        fun onClickCharge()
        fun onClickMore()
        fun onClickEvent()
        fun onClickClub()
    }
}