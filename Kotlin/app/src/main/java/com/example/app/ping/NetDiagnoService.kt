package com.example.app.ping

import android.content.Context

class NetDiagnoService {

    constructor(context: Context, host: String, packageName: String, version: String, deviceId: String, listener: NetDiagnoListener) {

    }

    fun start() {
        TODO("开始执行检测")
    }

    fun isCanceled(): Boolean {
        TODO("Not yet implemented")
    }

    fun cancel() {
        TODO("Not yet implemented")
    }

    /**
     * 停止诊断网络
     */
    fun stop() {
    }


}