package unab.edu.co.abrahamcaceres.taller_github

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import unab.edu.co.abrahamcaceres.taller_github.ui.theme.Taller_GithubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller_GithubTheme {
                ProfileScreen()
            }
        }
    }
}