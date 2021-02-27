
package com.example.tddscorekeeper

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tddscorekeeper.databinding.FragmentScoreKeeperBinding
import com.example.tddscorekeeper.di.DaggerAppComponent
import javax.inject.Inject


class ScoreKeeperFragment : Fragment() {


    private lateinit var binding: FragmentScoreKeeperBinding
    @Inject
    lateinit var  viewModel: MyViewModel

    lateinit var myContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.create().inject(this)
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

        return binding.root
    }
}