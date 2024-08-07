package com.example.switchexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.switchexample.ui.theme.SwitchExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwitchExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SwitchSample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SwitchSample(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var checked by remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Show it")
            Switch(checked = checked, onCheckedChange = { checked = it })
        }
        if (checked) { // conditional rendering
            Text(text = "Blah blah blah")
        }
        Text(text = "Some other component")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwitchExampleTheme {
        SwitchSample()
    }
}

