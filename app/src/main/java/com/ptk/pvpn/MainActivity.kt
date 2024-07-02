package com.ptk.pvpn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.pvpn.ui.theme.PVPNTheme
import com.ptk.pvpn.viewmodel.VpnViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PVPNTheme{
                VpnApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VpnApp(vpnViewModel: VpnViewModel = hiltViewModel()) {
    val vpnState by vpnViewModel.vpnState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("My VPN App") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = vpnState)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                if (vpnState == "Connected") {
                    vpnViewModel.stopVpn()
                } else {
                    vpnViewModel.startVpn()
                }
            }) {
                Text(text = if (vpnState == "Connected") "Disconnect" else "Connect")
            }
        }
    }
}
