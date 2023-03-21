package com.example.superheroesapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroesapp.R

data class SuperHero(
    @DrawableRes val imageResourceId: Int,
    @StringRes val heroName: Int,
    @StringRes val realName: Int,
    @StringRes val description: Int
)

val superheroes = listOf(
    //BLACK WIDOW
        SuperHero(
            R.drawable.black_widow,
            R.string.hero1_hero_name,
            R.string.hero1_real_name,
            R.string.hero1_description
        ),
    //CAPTAIN AMERICA
        SuperHero(
            R.drawable.captain_america,
            R.string.hero2_hero_name,
            R.string.hero2_real_name,
            R.string.hero2_description
        ),
    //HAWKEYE
        SuperHero(
            R.drawable.hawkeye,
            R.string.hero3_hero_name,
            R.string.hero3_real_name,
            R.string.hero3_description
        ),
    //HULK
        SuperHero(
            R.drawable.hulk,
            R.string.hero4_hero_name,
            R.string.hero4_real_name,
            R.string.hero4_description
        ),
    //IRON-MAN
        SuperHero(
            R.drawable.ironman,
            R.string.hero5_hero_name,
            R.string.hero5_real_name,
            R.string.hero5_description
        ),
    //THOR
        SuperHero(
            R.drawable.thor,
            R.string.hero6_hero_name,
            R.string.hero6_real_name,
            R.string.hero6_description
        ),
    //ANT-MAN
        SuperHero(
            R.drawable.antman,
            R.string.hero7_hero_name,
            R.string.hero7_real_name,
            R.string.hero7_description
        ),
    //SPIDER-MAN
        SuperHero(
            R.drawable.spiderman,
            R.string.hero8_hero_name,
            R.string.hero8_real_name,
            R.string.hero8_description
        ),
    //DOCTOR STRANGE
        SuperHero(
            R.drawable.doctor_strange,
            R.string.hero9_hero_name,
            R.string.hero9_real_name,
            R.string.hero9_description
        )
    )

