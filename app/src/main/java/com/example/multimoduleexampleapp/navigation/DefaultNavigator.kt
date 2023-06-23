package com.example.multimoduleexampleapp.navigation

import android.util.Log
import android.widget.Toast
import com.example.category_presentation.GoToNewsCategoryActivity
import com.example.common_utils.Activities
import com.example.common_utils.Navigator
import com.example.news_presentation.GoToNewsActivity
import com.example.newsdetail_presentation.GoToNewsDetailActivity
import com.example.search_presantation.GoToSearchActivity

class DefaultNavigator : Navigator.Provider {

    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.NewsActivity -> {
                GoToNewsActivity
            }
            Activities.SearchActivity -> {
                GoToSearchActivity
            }
            Activities.NewsCategoryActivity -> {
                GoToNewsCategoryActivity
            }
            Activities.NewsDetailActivity ->{
                GoToNewsDetailActivity
            }
        }
    }
}