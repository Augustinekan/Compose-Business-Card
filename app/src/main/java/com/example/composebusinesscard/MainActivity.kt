package com.example.composebusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebusinesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeBusinessCard()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeBusinessCard(modifier: Modifier = Modifier){
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .background(color = Color(0xff94aeb2))
                .height(height = screenHeight)
                .width(width = screenWidth),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(){}
            ImageProfileComposable()
            FooterSection()

        }

}

@Composable
fun ImageProfileComposable(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
            ){
        DeveloperImage()
        DeveloperName()
        Tagline()
    }
}

@Composable
fun DeveloperImage(modifier: Modifier = Modifier){
    val imageResource = painterResource(id = R.drawable.passport_photo);
    Image(painter = imageResource, contentDescription = "Passport Image", modifier = modifier
        .width(width = 120.dp)
        .height(height = 120.dp)
        .clip(CircleShape)
        .border(width = 2.dp, color =colorResource(
            id = R.color.JungleGreen
        ))
       )
}

@Composable
fun DeveloperName(modifier: Modifier = Modifier){
    Text(text = stringResource(id = R.string.NdunguAugustine),  fontSize = 28.sp,modifier = modifier.padding(12.dp))
}

@Composable
fun Tagline(){
    Text(text = stringResource(id = R.string.AndroidDev), color = colorResource(
        id = R.color.JungleGreen
    ), fontSize = 18.sp)
}


@Composable
fun FooterSection(modifier: Modifier = Modifier){
Column (
    modifier = modifier.padding(16.dp)
        ){
    FooterTile(
        icon = Icons.Rounded.Phone,
        text = "+254 777 888 ***"
    )
    FooterTile(icon = Icons.Rounded.Share, text ="@AndroidDev" )
    FooterTile(icon = Icons.Rounded.Email, text = "augustinekanyuira0@gmail.com")
}
}
@Composable
fun FooterTile(icon: ImageVector,text:String, modifier: Modifier = Modifier){
    Row (
        modifier = modifier.padding(vertical = 4.dp)
            ){
        Icon( imageVector = icon,  "phone", modifier = modifier.padding(horizontal = 12.dp),tint = colorResource(
            id = R.color.JungleGreen
        ))   // ok
        Text(text = text)
    }
}