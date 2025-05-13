package com.planet.martinezsarayanimalsapp.models

import com.google.gson.annotations.SerializedName

data class EnvironmentsItem(
    @SerializedName("_id") val _id: String,
    val description: String,
    val image: String,
    val name: String
)

val mockEnvironments = listOf(
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbb3",
        name = "Bosque Templado",
        image = "https://images.pexels.com/photos/531321/pexels-photo-531321.jpeg",
        description = "Los bosques templados se caracterizan por sus estaciones bien definidas y una gran variedad de árboles caducifolios."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbb4",
        name = "Pradera",
        image = "https://images.pexels.com/photos/462118/pexels-photo-462118.jpeg",
        description = "Las praderas son ecosistemas abiertos con pastos altos y pocas precipitaciones, ideales para grandes herbívoros."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbb5",
        name = "Manglar",
        image = "https://images.pexels.com/photos/750693/pexels-photo-750693.jpeg",
        description = "Los manglares son ecosistemas costeros tropicales donde predominan árboles adaptados a aguas salobres y mareas."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbb6",
        name = "Bosque Boreal",
        image = "https://images.pexels.com/photos/167684/pexels-photo-167684.jpeg",
        description = "El bosque boreal, también llamado taiga, es un bioma frío dominado por coníferas como los pinos y abetos."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbb7",
        name = "Humedal",
        image = "https://images.pexels.com/photos/1423600/pexels-photo-1423600.jpeg",
        description = "Los humedales son áreas inundadas donde se desarrolla una gran biodiversidad, vitales para aves migratorias y control de inundaciones."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbb8",
        name = "Ríos y Arroyos",
        image = "https://images.pexels.com/photos/3553216/pexels-photo-3553216.jpeg",
        description = "Ambientes de agua dulce con corrientes, hogar ideal para nutrias que se alimentan de peces y crustáceos."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbb9",
        name = "Sabana",
        image = "https://images.pexels.com/photos/60218/pexels-photo-60218.jpeg",
        description = "Las sabanas son extensas llanuras tropicales con vegetación dispersa, donde habitan leones y grandes herbívoros."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbba",
        name = "Océano",
        image = "https://images.pexels.com/photos/2765872/pexels-photo-2765872.jpeg",
        description = "Ambiente marino vasto y profundo, donde viven delfines, conocidos por su inteligencia y habilidades sociales."
    ),
    EnvironmentsItem(
        _id = "680c0510d10bbc79144edbbb",
        name = "Selva Tropical",
        image = "https://images.pexels.com/photos/1619318/pexels-photo-1619318.jpeg",
        description = "La selva tropical es un ecosistema húmedo y denso con vegetación exuberante, hábitat natural del tigre de Bengala."
    )
)