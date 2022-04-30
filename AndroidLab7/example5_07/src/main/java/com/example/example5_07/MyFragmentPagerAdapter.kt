package com.example.example5_07

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentPagerAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {
    val fragments : List<Fragment>

    init {
        fragments = listOf(FragmentMain(), FragmentSub())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}