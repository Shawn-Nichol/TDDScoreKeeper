
package com.example.tddscorekeeper

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tddscorekeeper.databinding.FragmentScoreKeeperBinding
import com.example.tddscorekeeper.di.MyApplication
import javax.inject.Inject


class ScoreKeeperFragment : Fragment() {


    private lateinit var binding: FragmentScoreKeeperBinding

    @Inject
    lateinit var  viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        Log.i("MyTest", "Score ${viewModel.logScore}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score_keeper, container, false )


        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}