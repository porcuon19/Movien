package kz.porcuon.movien

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kz.porcuon.movien.movies.MoviesFragment

private const val PAGES_NUM = 3

class HomePagerAdapter(
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = PAGES_NUM

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> MoviesFragment()
        1 -> FavoritesFragment()
        2 -> ProfileFragment()
        else -> throw IllegalArgumentException()
    }
}