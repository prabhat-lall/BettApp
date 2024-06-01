package com.example.betapp.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.betapp.databinding.FragmentTrendingBinding
import com.example.betapp.presentation.MatchBidBottomSheetFragment

class TrendingFragment : Fragment() {

    private lateinit var binding: FragmentTrendingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

    }

    private fun initListeners() {
        binding.btnBetOne.setOnClickListener {
            openBidBottomSheetFragment()
        }
        binding.btnBetTwo.setOnClickListener {
            openBidBottomSheetFragment()
        }
        binding.btnBetThree.setOnClickListener {
            openBidBottomSheetFragment()
        }
    }

    private fun openBidBottomSheetFragment() {
        val bottomSheetFragment = MatchBidBottomSheetFragment()
        // bottomSheetFragment.isCancelable = true
        bottomSheetFragment.show(requireActivity().supportFragmentManager, bottomSheetFragment.tag)

    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TrendingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}