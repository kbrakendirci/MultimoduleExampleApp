package com.example.category_presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.category_data.Category
import com.example.category_presentation.databinding.ActivityNewsCategoryBinding
import com.example.common_utils.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsCategoryActivity : AppCompatActivity(), CategoryAdapter.OnItemClickListener {

    private var _binding: ActivityNewsCategoryBinding? = null
    private val binding: ActivityNewsCategoryBinding get() = _binding!!

    @Inject
    lateinit var navigation: Navigator.Provider


    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, NewsCategoryActivity::class.java)
            activity.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityNewsCategoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val extras = Bundle().apply {
            putString("article", "dd")
        }
        //navigation.getActivities(Activities.NewsCategory).navigate(this,null)

        val items = ArrayList<Category>()
        // adding categories to the list
        items.add(Category("Technology", R.drawable.techno))
        items.add(Category("Entertainment", R.drawable.entetaintment))
        items.add(Category("Business", R.drawable.business))
        items.add(Category("Science", R.drawable.science))
        items.add(Category("Sports", R.drawable.sports))
        items.add(Category("General", R.drawable.generally))
        items.add(Category("Health", R.drawable.generally))

        val adapter = CategoryAdapter(items, this)
        binding.categoriesRecyclerView.adapter = adapter
    }

    @Inject
    lateinit var provider: Navigator.Provider
    override fun onItemClick(category: Category) {

    }

}

object GoToNewsCategoryActivity : Navigator {
    override fun navigate(activity: Activity, bundle: Bundle?) {
        NewsCategoryActivity.launchActivity(activity)
    }
}