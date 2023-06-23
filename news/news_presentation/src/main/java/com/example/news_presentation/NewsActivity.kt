package com.example.news_presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.common_utils.Activities
import com.example.common_utils.Navigator
import com.example.news_domain.model.Article
import com.example.news_presantation.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : AppCompatActivity(),NewsAdapter.OnItemClickListener {

    private var _binding: ActivityNewsBinding? = null
    private val binding: ActivityNewsBinding get() = _binding!!

    private val newsViewModel: NewsViewModel by viewModels()
    private val newsAdapter = NewsAdapter(this)
    private var category: String? = null

    companion object {
        fun launchActivity(activity: Activity, extras: Bundle?) {
            val intent = Intent(activity, NewsActivity::class.java)
            extras?.let {
                intent.putExtras(it)
            }
            activity.startActivity(intent)
        }
    }

    @Inject
    lateinit var provider:Navigator.Provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setObservers()
    }


    private fun initView() {
        binding.rvArticles.adapter = newsAdapter
        binding.ivGoToSearch.setOnClickListener {
            provider.getActivities(Activities.SearchActivity).navigate(this)
        }
        if (intent.hasExtra("CATEGORY")) {
            category= intent.getStringExtra("CATEGORY")
            newsViewModel.getNewsCategory("$category")
        }
    }

    private fun setObservers() {
        lifecycleScope.launchWhenStarted {
            newsViewModel.newsArticle.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@NewsActivity, it.error, Toast.LENGTH_LONG).show()
                }
                it.data?.let {
                    binding.progressBar.visibility = View.GONE
                    newsAdapter.setData(it)
                }
            }
        }
    }

    override fun onItemClick(item: Article) {
        val bundle=Bundle()
        val title = item.title
        bundle.putString("Title","$title")
        provider.getActivities(Activities.NewsDetailActivity).navigate(this,bundle)
    }
}
//bundle.getString("key1")
object GoToNewsActivity : Navigator {
    override fun navigate(activity: Activity, bundle: Bundle?) {
        NewsActivity.launchActivity(activity,bundle)
    }
}