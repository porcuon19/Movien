package kz.porcuon.movien

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.*
import kz.porcuon.movien.support.AbstractFragment

class HomeFragment : AbstractFragment() {

    override val layoutId = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = HomePagerAdapter(childFragmentManager)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_bottom_popular -> viewPager.currentItem = 0
                R.id.menu_bottom_favorites -> viewPager.currentItem = 1
                R.id.menu_bottom_profile -> viewPager.currentItem = 2
            }
            true
        }
    }
}