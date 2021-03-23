package com.example.app.ping

/**
 * 监控网络诊断回调
 */
interface NetDiagnoListener {

    /**
     * ping过程中更新的日志
     */
    fun onUpdated(log: String)

    /**
     * 结束后返回日志
     */
    fun onFinish(log: String)

    /**
     * 状态变动
     * @param isParseOk 域名解析是否成功
     * @param isSocketConnected socket中conected是否成功
     */
    fun onNetStates(isParseOk: Boolean, isSocketConnected: Boolean)
}