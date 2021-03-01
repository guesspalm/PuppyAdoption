/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar

val puppies: List<Puppy> = listOf(
    Puppy(
        res = R.drawable.puppy_0,
        name = "怪兽",
        age = "1岁",
        gender = "公",
        desc = "做全套疫苗 他的主人没时间没精力也没用心也不会养，只是养着玩，也没给狗狗办户口，疫苗驱虫全不做，我已经给做了绝育驱虫，现在已经弃养不管它了，我能力有限，只能暂时收留，希望能帮它找个真正爱它负责的好主人。"
    ),
    Puppy(
        res = R.drawable.puppy_2,
        name = "大白",
        age = "2岁",
        gender = "公",
        desc = "希望有好心人能够领养 小黑很可爱，喜欢追着自己的尾巴咬，很亲人，特别会撒娇，睡觉的时候小动作很多"
    ),
    Puppy(
        res = R.drawable.puppy_1,
        name = "Haney",
        age = "1岁",
        gender = "公",
        desc = "有固定住所（不接受合租），有稳定收入，家人同意领养，不因任何理由弃养。"
    ),
    Puppy(
        res = R.drawable.puppy_3,
        name = "太子妃",
        age = "2岁",
        gender = "母",
        desc = "邻家小妹妹在垃圾桶里捡回来的，4个多月大，非常聪明懂事，会听指令，会很多技能，找有爱心有责任心的深圳居住的家庭领养。"
    ),
)

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(this)
            }
        }
    }
}

// Start building your app here!
@ExperimentalFoundationApi
@Composable
fun MyApp(context: Context?) {
    Scaffold(topBar = { TopAppBar(title = { Text("Welcome") }) }) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(puppies.size) { index ->
                PuppyItem(context, puppies[index])
            }
        }
    }
}

@Composable
fun PuppyItem(context: Context?, puppy: Puppy) {
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("puppy", puppy)
            context?.startActivity(intent)
        }, contentAlignment = Alignment.BottomCenter) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = puppy.res),
            contentDescription = puppy.name,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0x99000000))
        ) {
            Text(
                text = puppy.name + " " + puppy.age + " " + puppy.gender,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            )
        }

    }

}


@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(null)
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(null)
    }
}
