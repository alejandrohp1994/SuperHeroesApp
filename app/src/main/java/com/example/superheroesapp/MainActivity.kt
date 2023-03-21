package com.example.superheroesapp

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.data.SuperHero
import com.example.superheroesapp.data.superheroes
import com.example.superheroesapp.ui.theme.SuperHeroTheme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroTheme {
                    SuperHeroesApp()
                }
            }
        }
    }

@Composable
fun SuperHeroesApp() {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
        items(superheroes) {
            SuperHeroItem(superhero = it)
        }
    }
}

@Composable
fun SuperHeroItem(superhero: SuperHero, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val boxColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface)

    val fontColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface)

    Card(
        modifier =  modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column (modifier = Modifier.background(color = boxColor)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                SuperHeroIcon(superhero.imageResourceId)
                SuperHeroNames(
                    superhero.heroName,
                    superhero.realName,
                    fontColor
                        )
                Spacer(Modifier.weight(1f))
                MoreButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded}
                )
            }
            if (expanded) {
                SuperHeroDescription(superhero.description, fontColor)
            }
        }
    }
}

@Composable
fun SuperHeroIcon(@DrawableRes superheroIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(superheroIcon),
        contentDescription = null
    )
}

@Composable
fun SuperHeroNames(@StringRes heroName: Int, @StringRes realName: Int, @ColorRes fontColor: Color, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(heroName),
            fontSize = 26.sp,
            color = fontColor,
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxSize(0.9f)
        )
        Text(
            text = stringResource(realName),
            color = fontColor,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun SuperHeroDescription(@StringRes superheroDescription: Int, @ColorRes fontColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(R.string.about),
            color = fontColor,
            style = MaterialTheme.typography.h3,
        )
        Text(
            text = stringResource(superheroDescription),
            color = fontColor,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun MoreButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

/**
 * Composable that displays what the UI of the app looks like in light theme in the design tab.
 */
@Preview
@Composable
fun SuperHeroAppPreview() {
    //Change to true anytime to change for dark mode
    SuperHeroTheme(darkTheme = false) {
        SuperHeroesApp()
    }
}

@Preview
@Composable
fun DarkThemePreview() {
    SuperHeroTheme(darkTheme = true) {
        SuperHeroesApp()
    }
}