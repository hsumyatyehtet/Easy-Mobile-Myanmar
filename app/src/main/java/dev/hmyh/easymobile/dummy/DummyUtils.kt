package dev.hmyh.easymobile.dummy

import dev.hmyh.easymobile.R
import dev.hmyh.easymobile.data.vos.HomeCategoryVO

fun getCategoryList(): List<HomeCategoryVO>{

    val homeCategorySocialMedia = HomeCategoryVO()
    homeCategorySocialMedia.id = 1
    homeCategorySocialMedia.image = R.drawable.easy_mobile_cover
    homeCategorySocialMedia.title = "Social Media"

    val homeCategoryLinks = HomeCategoryVO()
    homeCategoryLinks.id = 2
    homeCategoryLinks.image = R.drawable.easy_mobile_cover
    homeCategoryLinks.title = "Links"

    val homeCategoryCloud = HomeCategoryVO()
    homeCategoryCloud.id = 3
    homeCategoryCloud.image = R.drawable.easy_mobile_cover
    homeCategoryCloud.title = "Cloud"

    val homeCategoryWallPaper = HomeCategoryVO()
    homeCategoryWallPaper.id = 4
    homeCategoryWallPaper.image = R.drawable.easy_mobile_cover
    homeCategoryWallPaper.title = "Wallpaper Photos"

    return listOf(
       homeCategorySocialMedia,homeCategoryLinks,homeCategoryCloud,homeCategoryWallPaper
    )
}