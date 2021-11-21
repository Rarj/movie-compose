package dev.arj.noidea.feature.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dev.arj.noidea.ui.theme.NoIdeaTheme

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoIdeaTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }

}