package com.example.betapp.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.betapp.databinding.FragmentMatchDetailsBinding
import com.example.betapp.presentation.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
const val ARG_MATCH_ID = "argMatchId"
class MatchDetailsFragment : Fragment() {

    private var matchId: String? = null

    private lateinit var binding: FragmentMatchDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            matchId = it.getString(ARG_MATCH_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMatchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initVPAdapter()
    }

    private fun initVPAdapter() {
        val fragments = listOf(TrendingFragment(), MarketArenaFragment(), HeadToHeadFragment())
        val adapter = ViewPagerAdapter(requireActivity(), fragments)
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab?.position ?: 0
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
        binding.viewPager.adapter = adapter
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

    }


    companion object {

        @JvmStatic
        fun newInstance(matchId: String) =
            MatchDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MATCH_ID, matchId)
                }
            }
    }
}