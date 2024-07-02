package com.ptk.pvpn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ptk.pvpn.repository.VpnRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VpnViewModel @Inject constructor(
    private val repository: VpnRepository
) : ViewModel() {

    private val _vpnState = MutableStateFlow("Disconnected")
    val vpnState: StateFlow<String> = _vpnState

    fun startVpn() {
        viewModelScope.launch {
            _vpnState.value = repository.startVpn()
        }
    }

    fun stopVpn() {
        viewModelScope.launch {
            _vpnState.value = repository.stopVpn()
        }
    }
}
