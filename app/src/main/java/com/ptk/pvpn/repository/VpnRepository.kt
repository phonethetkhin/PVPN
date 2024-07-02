package com.ptk.pvpn.repository

import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class VpnRepository @Inject constructor(
    private val client: HttpClient
) {
    suspend fun startVpn(): String {
        return "asdf"
    }

    suspend fun stopVpn(): String {
        return "adsf"
    }
}
