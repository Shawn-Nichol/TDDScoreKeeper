
package com.example.tddscorekeeper.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.databinding.FragmentScoreKeeperBinding
import com.example.tddscorekeeper.di.MyApplication
import com.example.tddscorekeeper.main.MyViewModel
import javax.inject.Inject


class ScoreKeeperFragment(private val viewModel: MyViewModel) : Fragment() {


    private lateinit var binding: FragmentScoreKeeperBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score_keeper, container, false )


        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        liveDataObserver()

        return binding.root
    }

    fun liveDataObserver() {
        viewModel.scoreLiveData.observe(viewLifecycleOwner, {
            Log.i("Practice", "New score is $it")
        } )
    }
}