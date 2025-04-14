package com.steeplesoft.stateissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Always create the root component outside Compose on the main thread
        val rootComponent = RootComponentImpl(defaultComponentContext())

        setContent {
            App(rootComponent = rootComponent)
        }
    }
}
