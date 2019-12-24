package kz.porcuon.movien.flow.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kz.porcuon.movien.flow.movies.MoviesFragment
import kz.porcuon.movien.flow.profile.ProfileFragment

private const val PAGES_NUM = 2

class HomePagerAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = PAGES_NUM

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> MoviesFragment()
        1 -> ProfileFragment()
        else -> throw IllegalArgumentException()
    }
}