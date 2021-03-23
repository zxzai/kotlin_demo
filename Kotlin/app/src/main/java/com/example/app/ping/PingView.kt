package com.example.app.ping

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ScrollView
import android.widget.TextView

class PingView(context: Context, attr: AttributeSet? = null) : ScrollView(context, attr), NetDiagnoListener {


    private val textView: TextView = TextView(context)
    private var showInfo: String = ""
    private var netDiagnoService: NetDiagnoService? = null
    private var listener: NetDiagnoListener? = null

    private var deviceId = ""
    private var versionName = ""

    init {
        textView.setTextColor(Color.BLACK)
        textView.textSize = 26f
        addView(textView)
    }

    fun pingHost(host: String) {
        showInfo = "hello world"
        updateText(showInfo)
        netDiagnoService?.let {
            if (!it.isCanceled()) {
                it.cancel()
            }
        }

        netDiagnoService = NetDiagnoService(context, host, context.packageName, versionName,
                deviceId, this)
        netDiagnoService!!.start()
    }


    private fun updateText(text: String) {
        textView.text = text
    }

    override fun onUpdated(log: String) {
        TODO("Not yet implemented")
    }

    override fun onFinish(log: String) {
        TODO("Not yet implemented")
    }

    override fun onNetStates(isParseOk: Boolean, isSocketConnected: Boolean) {
        TODO("Not yet implemented")
    }


}