package com.example.betapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.betapp.R
import com.example.betapp.data.model.WalletDTO
import com.example.betapp.databinding.FragmentHomeBinding
import com.example.betapp.domain.model.Match
import com.example.betapp.domain.model.Sport
import com.example.betapp.presentation.adapter.MatchAdapter
import com.example.betapp.presentation.adapter.SportTypeAdapter
import com.example.betapp.presentation.screens.MatchDetailsFragment
import com.example.betapp.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by activityViewModels()
    private var sportTypeList : List<Sport> = listOf()
    private var matchList : List<Match> = listOf()
    private var wallet : WalletDTO? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callHomeScreenApi()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initUI()
        initListeners()
    }

    private fun initListeners() {

    }

    private fun callHomeScreenApi() {
        viewModel.fetchHomeScreenData(requireContext())
        viewModel.fetchUserWallet(requireContext())
    }

    private fun initObserver() {
        viewModel.sportsTypeListLiveData.observe(viewLifecycleOwner){
            sportTypeList = it
            initSportAdapter()
            Log.d("_prabhat", "initObserver:${sportTypeList} ")
        }

        viewModel.matchLiveData.observe(viewLifecycleOwner){
            matchList = it
            initMatchAdapter()
            Log.d("_prabhat", "initObserver matchList:${matchList} ")
        }

        viewModel.walletLiveData.observe(viewLifecycleOwner){
            binding.tvCoin.text = it.coinAmount.toString()
            Log.d("_prabhat", "initObserver:coin ${it.coinAmount.toString()} ")
        }
    }



    private fun initMatchAdapter() {
        binding.rvMatches.adapter = MatchAdapter(matchList,::activeButtonClick)
        binding.rvMatches.isNestedScrollingEnabled = false
        binding.rvMatches.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    private fun activeButtonClick(matchID: Int) {
        Toast.makeText(requireContext(),matchID.toString(),Toast.LENGTH_SHORT).show()
        var fragment = MatchDetailsFragment.newInstance(matchID.toString())
        requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack(HomeFragment::class.java.name).replace(
            R.id.container_view,fragment
        ).commitAllowingStateLoss()
    }

    private fun initUI() {

    }

    private fun initSportAdapter() {
        binding.rvSports.adapter = SportTypeAdapter(sportTypeList.toMutableList())
        binding.rvSports.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
    }



}