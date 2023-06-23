package com.example.newsdetail_presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.common_utils.Navigator
import com.example.newsdetail_presentation.databinding.ActivityNewsDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class NewsDetailActivity : AppCompatActivity() {

    private var _binding: ActivityNewsDetailBinding?= null
    private val binding: ActivityNewsDetailBinding get() = _binding!!

    private val newsViewModel: NewsDetailViewModel by viewModels()

    @Inject
    lateinit var provider:Navigator.Provider

    companion object{
        fun launchActivity(activity: Activity, extras: Bundle?) {
            val intent = Intent(activity, NewsDetailActivity::class.java)
            extras?.let {
                intent.putExtras(it)
            }
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setObservers()
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            newsViewModel.newsArticle.collectLatest {
                if (it.isLoading) {
                    //binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    //binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@NewsDetailActivity, it.error, Toast.LENGTH_LONG).show()
                }
                it.data?.let {

                }
            }
        }
    }

    private fun initView() {
        if (intent.hasExtra("Title")) {
            title= intent.getStringExtra("Title")
            newsViewModel.getNewsCategory("$title")
        }
    }
}

object GoToNewsDetailActivity:Navigator{
    override fun navigate(activity: Activity, bundle: Bundle?) {
        NewsDetailActivity.launchActivity(activity,bundle)
    }
}