package com.steeplesoft.stateissue

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.value.MutableValue

class Foo(
    val bar: String,
    var baz: List<Pair<String, Holder>>
)

class Holder(
    var count: Int
)

@Composable
fun foo(modifier: Modifier = Modifier) {
    val compfoo: MutableValue<List<Foo>> = MutableValue(
        mutableListOf(
            Foo(
                "Foo 1", listOf(
                    Pair("One", Holder(1)),
                    Pair("Two", Holder(2)),
                    Pair("Three", Holder(3)),
                )
            ),
            Foo(
                "Foo 2", listOf(
                    Pair("One - 2", Holder(4)),
                    Pair("Two - 2", Holder(5)),
                    Pair("Three - 2", Holder(6)),
                )
            )
        )
    )

    val foos by compfoo.subscribeAsState()
    var selectedFoo by remember { mutableStateOf(foos.first()) }

    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState()
    ) {
        item {
            ComboBox(label = "Foo",
                selected = selectedFoo,
                onChange = {
                    selectedFoo = it
                },
                items = foos,
                itemLabel = { it.bar }
            )
        }

        items(selectedFoo.baz/*, key = { "${it.second.personId}-${it.second.mealId}-${it.second.itemId}" }*/) { baz ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(0.8f).padding(end = 10.dp)) {
                    Text(text = baz.first, fontSize = 20.sp)
                }
                Column(modifier = Modifier.weight(0.2f).padding(end = 10.dp)) {
                    ComboBox(
                        label = "",
//                        key = "${baz.hashCode()}",
                        selected = baz.second.count.toString(),
                        itemLabel = { it },
                        onChange = { baz.second.count = it.toInt() },
                        items = listOf("0", "1", "2", "3", "4", "5"),
                    )
                }
            }
        }
        item {
            Row {
                val columnModifier = Modifier.fillMaxWidth().weight(0.5f)
                val buttonModifier = Modifier.fillMaxWidth().padding(5.dp)
                Column(modifier = columnModifier) {
                    Button(onClick = { }, modifier = buttonModifier) {
                        Text("Save")
                    }
                }
                Column(modifier = columnModifier) {
                    Button(onClick = { }, modifier = buttonModifier) {
                        Text("Cancel")
                    }
                }
            }
        }
    }
}
