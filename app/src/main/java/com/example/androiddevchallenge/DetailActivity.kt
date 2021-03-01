package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppy = intent.getParcelableExtra<Puppy>("puppy")
        setContent {
            MyTheme {
                Scaffold(topBar = {
                    TopAppBar(title = { Text("Detail") }, navigationIcon = {
                        Button(onClick = {
                            onBackPressed()
                        }) {
                            Image(
                                painter = painterResource(R.drawable.icon_back),
                                contentDescription = "back",
                                colorFilter = ColorFilter.tint(Color.White)
                            )
                        }
                    })
                }) {
                    if (puppy != null) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            Column( modifier = Modifier.verticalScroll(rememberScrollState()) ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = puppy.res),
                                    contentDescription = puppy.name,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = puppy.name + " " + puppy.age + " " + puppy.gender,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp
                                    )
                                )
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = puppy.desc ?: "" ,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 14.sp,
                                        lineHeight = 16.sp,
                                    )
                                )

                            }

                        }
                    }

                }
            }
        }
    }
}
