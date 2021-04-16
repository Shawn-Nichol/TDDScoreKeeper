package com.example.tddscorekeeper.main.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.tddscorekeeper.main.MyViewModel

class MainFragmentFactory(private val viewModel: MyViewModel) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            MyFragment::class.java.name -> {
                MyFragment(viewModel)
            } else -> super.instantiate(classLoader, className)
        }
    }
}