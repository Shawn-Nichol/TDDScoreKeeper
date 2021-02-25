
package com.example.tddscorekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tddscorekeeper.databinding.FragmentScoreKeeperBinding


class ScoreKeeperFragment : Fragment() {


    private lateinit var binding: FragmentScoreKeeperBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score_keeper, container, false )
        binding.binding = this


        return binding.root
    }

    fun countUp() {

    }

    fun countDown() {

    }
}