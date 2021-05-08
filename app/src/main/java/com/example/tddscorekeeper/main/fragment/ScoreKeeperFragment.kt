
package com.example.tddscorekeeper.main.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tddscorekeeper.R
import com.example.tddscorekeeper.databinding.FragmentScoreKeeperBinding
import com.example.tddscorekeeper.di.MyApplication
import com.example.tddscorekeeper.main.MainViewModel


/**
 * ViewModel passed in with Fragment factory, this allows for easier testing. Know you can pass in a
 * mock ViewModel.
 */
class ScoreKeeperFragment(private val viewModel: MainViewModel) : Fragment() {

    private lateinit var binding: FragmentScoreKeeperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as MyApplication).appComponent.inject(this)
        requireActivity().supportFragmentManager.fragmentFactory = MainFragmentFactory(viewModel)
        super.onCreate(savedInstanceState)
        // Adds menu to activity.
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score_keeper, container, false )
        // Passes the ViewModel to the binding, to be used in the xml
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_reset_score -> {
                findNavController().navigate(R.id.action_scoreKeeperFragment_to_resetScoreDialog)
                true
            }
            R.id.menu_reset_high_score -> {
                findNavController().navigate(R.id.action_dest_scoreKeeperFragment_to_resetHighScoreDialog)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }




}