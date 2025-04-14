package com.steeplesoft.stateissue

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.steeplesoft.stateissue.App
import com.steeplesoft.stateissue.RootComponentImpl

fun MainViewController() = ComposeUIViewController {
    val rootComponent = remember {
        RootComponentImpl(DefaultComponentContext(ApplicationLifecycle()))
    }
    App(rootComponent)
}
