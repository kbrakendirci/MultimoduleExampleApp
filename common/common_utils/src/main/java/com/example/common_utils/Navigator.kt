package com.example.common_utils

import android.app.Activity
import android.os.Bundle

interface Navigator {

    fun navigate(activity: Activity,bundle:Bundle?=null)

    interface Provider{
        fun getActivities(activities: Activities):Navigator
    }
}