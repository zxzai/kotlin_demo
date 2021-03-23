package com.example.app.ping

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ScrollView
import android.widget.TextView

/**
 * PING结果视图
 */
class PingView(context: Context, attr: AttributeSet? = null) : ScrollView(context, attr), NetDiagnoListener {
    private val textView: TextView = TextView(context)
    private var netDiagnoService: NetDiagnoService? = null
    var listener: NetDiagnoListener? = null

    //日志信息
    var logInfo: String = ""

    //设备id
    var deviceId = ""

    //版本号
    var versionName = ""

    init {
        textView.setTextColor(Color.BLACK)
        textView.textSize = 26f
        addView(textView)
    }

    fun pingHost(host: String) {
        logInfo = "hello world"
        updateText(logInfo)
        netDiagnoService?.let {
            if (!it.isCanceled()) {
                it.cancel()
            }
        }

        netDiagnoService = NetDiagnoService(context, host, context.packageName, versionName,
                deviceId, this)
        netDiagnoService!!.start()
    }

    /**
     * 取消ping
     */
    fun cancelPing() {
        netDiagnoService?.stop()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        cancelPing()
    }

    private fun updateText(text: String) {
        textView.text = text
    }

    override fun onUpdated(log: String) {
        listener?.onUpdated(log)
        logInfo += log
        updateText(logInfo)
        fullScroll(FOCUS_DOWN)
    }

    /**
     * 诊断结束，输出全部日志记录
     *
     * @param log log日志输出
     */
    override fun onFinish(log: String) {
        listener?.onFinish(log)
        updateText(log)
        fullScroll(FOCUS_DOWN)
    }

    override fun onNetStates(isParseOk: Boolean, isSocketConnected: Boolean) {
        TODO("Not yet implemented")
    }


}