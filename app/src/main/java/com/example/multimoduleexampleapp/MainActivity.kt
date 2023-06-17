package com.example.multimoduleexampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import com.example.common_utils.Activities
import com.example.common_utils.Navigator
import com.example.multimoduleexampleapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var provider:Navigator.Provider

    private var _binding:ActivityMainBinding?=null
    private val binding:ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this,R.color.white)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.myLooper()!!).postDelayed({
            provider.getActivities(Activities.NewsCategoryActivity).navigate(this)
            finish()
        },1500)

        provider.getActivities(Activities.NewsCategoryActivity).navigate(this)
    }
}