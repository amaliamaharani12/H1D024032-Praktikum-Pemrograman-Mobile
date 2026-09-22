package ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ui.screen.DaftarProductScreen
import com.pemmob.rani.ui.theme.PraktikumMobileJualanTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumMobileJualanTheme {
                DaftarProductScreen()
            }
        }
    }
}