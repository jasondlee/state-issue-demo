package com.steeplesoft.stateissue

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi

interface RootComponent {
}

@OptIn(DelicateDecomposeApi::class)
class RootComponentImpl(componentContext: ComponentContext) :
    RootComponent, ComponentContext by componentContext {

}
