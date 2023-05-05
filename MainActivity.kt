package com.example.login_page

import android.media.Image
import android.os.Bundle
import android.widget.Space
//import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_page.ui.theme.Login_pageTheme
import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
//import java.text.NumberFormatmport android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
//import com.example.birthdaycard.ui.theme.BirthdayCardTheme
//import kotlinx.coroutines.NonCancellable.message
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            forImage()
        }
    }
}
@Composable
fun LoginPage() {
    var gram by remember { mutableStateOf("") }
    var kilogram by remember { mutableStateOf("") }
    val grams =gram.toDoubleOrNull()?:0.0
    val kilograms = kilogram.toDoubleOrNull()?:0.0
    val kilo = calculategram(grams)
    val gra = calculateKilo(kilograms)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Unit convertor",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Green
        )
        Spacer(Modifier.height(32.dp))
        Text(
            text="Grams",
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
        color= Color.Cyan
        )
        Spacer(Modifier.height(32.dp))
        TextField(
            value = gram,
            onValueChange = { gram = it },
            label={
                Column() {
                    Text(text="enter grams")
                }
            },
            modifier = Modifier
                .padding(15.dp)
                .background(color = Color.White),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            //keyboardOptions = keyboardOptions(keyboardType=keyboardType.Number)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = kilo+"KG",
            fontSize = 17.sp ,
            fontWeight = FontWeight.Bold,
            color= Color.Cyan
        )
        Spacer(Modifier.height(10.dp))
        Text(
                text="kilograms",
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
            color= Color.Cyan
                )
        Spacer(Modifier.height(10.dp))
        TextField(
            value = kilogram,
            onValueChange = { kilogram= it },
            label={
                Column() {
                    Text(text="enter kilograms")
                }
            },
            modifier = Modifier
                .padding(15.dp)
                .background(color = Color.White),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text=gra+"grams",
            fontSize=17.sp,
            fontWeight = FontWeight.Bold,
            color= Color.Cyan
        )
//        Button(
//            onClick = { /* Handle login button click */ },
//            modifier = Modifier.padding(top = 16.dp)
//        ) {
//            Text(text = "convert")
//        }
    }
}
@Composable
fun forImage(){
    val image= painterResource(R.drawable.cback)
Box{
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
             contentScale= ContentScale.Crop
            )
            LoginPage()
}
}
private fun calculateKilo(gra:Double):String{
    val a=gra*1000
    return NumberFormat.getInstance().format(a)
}
private fun calculategram(kil:Double):String{
    val b=kil/1000
    return NumberFormat.getInstance().format(b)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login_pageTheme {
        LoginPage()
    }
}