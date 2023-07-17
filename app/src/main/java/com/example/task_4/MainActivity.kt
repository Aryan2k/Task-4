package com.example.task_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_4.ui.theme.BlueBox
import com.example.task_4.ui.theme.BlueShade
import com.example.task_4.ui.theme.BlueTint
import com.example.task_4.ui.theme.GrayText
import com.example.task_4.ui.theme.GrayTint
import com.example.task_4.ui.theme.GreenTint
import com.example.task_4.ui.theme.RedTint
import com.example.task_4.ui.theme.Task4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task4Theme {
                HomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(BlueShade)
            ) {
               // PaymentFailedScreen()
                PaymentReceivedScreen()
            }
        }, topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = BlueShade),
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "app logo",
                        modifier = Modifier
                            .width(48.dp)
                            .height(31.dp)
                    )
                },
            )
        })
}

@Composable
fun PaymentFailedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .align(CenterHorizontally)
                .border(
                    border =
                    BorderStroke(
                        1.dp,
                        RedTint
                    ),
                    shape = CircleShape
                )
        )
        {
            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = "app logo",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Payment Failed",
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "You have insufficient fund.",
            color = GrayText,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .width(300.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(2.dp)),
            colors = ButtonDefaults.buttonColors(RedTint),
            shape = RoundedCornerShape(size = 2.dp),
        ) {
            Text(text = "Retry Payment", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .width(300.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(2.dp)),
            colors = ButtonDefaults.buttonColors(BlueTint),
            shape = RoundedCornerShape(size = 2.dp),
        ) {
            Text(text = "Cancel", fontSize = 14.sp)
        }
    }
}

@Composable
fun PaymentReceivedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(72.dp)
                .align(CenterHorizontally)
                .border(
                    border =
                    BorderStroke(
                        1.dp,
                        GreenTint
                    ),
                    shape = CircleShape
                )
        )
        {
            Image(
                painter = painterResource(id = R.drawable.tick),
                contentDescription = "app logo",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Payment Received",
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "We’ve received your payment, Sanjeet.",
            color = GrayText,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(BlueBox)
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = 32.dp,
                        top = 32.dp,
                        end = 32.dp
                    ), text = "Payment Details", color = Color.White, fontSize = 12.sp
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, top = 8.dp, end = 32.dp), thickness = 2.dp,
                    color = GrayTint
                )
                LazyColumn(
                    modifier = Modifier.padding(
                        start = 32.dp,
                        bottom = 32.dp,
                        end = 32.dp
                    )
                ) {
                    val itemList = getItemList()
                    items(itemList) { item ->
                        ListItem(
                            attribute = item.first,
                            value = item.second,
                            itemList.indexOf(item) == itemList.lastIndex
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .width(300.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(2.dp)),
            colors = ButtonDefaults.buttonColors(RedTint),
            shape = RoundedCornerShape(size = 2.dp),
        ) {
            Text(text = "Continue", fontSize = 14.sp)
        }
    }
}

@Composable
fun ListItem(attribute: String, value: String, isLastItem: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = attribute,
            color = GrayText,
            fontSize = 12.sp,
        )
        Text(
            text = value,
            color = Color.White,
            fontSize = 12.sp
        )
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp), thickness = if (isLastItem) 2.dp else 1.dp,
        color = GrayTint
    )
}

fun getItemList(): List<Pair<String, String>> {
    return listOf(
        Pair("Payment Amount", "$12.99"),
        Pair("Plan", "Monthly"),
        Pair("Next Billing Date", "12/08/2024"),
        Pair("Transaction #ID", "MSN023AY2023678"),
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task4Theme {
        HomeScreen()
    }
}