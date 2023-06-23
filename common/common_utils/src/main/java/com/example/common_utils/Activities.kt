package com.example.common_utils

sealed class Activities{
    object NewsActivity:Activities()
    object SearchActivity:Activities()
    object NewsCategoryActivity: Activities()
    object NewsDetailActivity: Activities()
}
