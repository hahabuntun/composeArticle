package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeArticle(
                        heading = stringResource(R.string.article_heading),
                        description = stringResource(R.string.article_description),
                        text = stringResource(R.string.article_text),
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(heading: String, description: String, text: String, modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        TopImage()
        Heading(heading)
        Description(description)
        ArticleText(text)
    }

}


@Composable
fun TopImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun Heading(heading: String, modifier: Modifier = Modifier) {
    Text(
        text = heading,
        modifier = Modifier.padding(16.dp),
        fontSize = 24.sp
    )
}

@Composable
fun Description(description: String, modifier: Modifier = Modifier) {
    Text(
        text = description,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Composable
fun ArticleText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeArticle(
            heading = stringResource(R.string.article_heading),
            description = stringResource(R.string.article_description),
            text = stringResource(R.string.article_text),
        )
    }
}