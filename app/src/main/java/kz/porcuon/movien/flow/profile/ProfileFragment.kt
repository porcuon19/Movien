package kz.porcuon.movien.flow.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_profile.*
import kz.porcuon.data.sources.preferences.clearSessionId
import kz.porcuon.movien.R
import kz.porcuon.movien.flow.home.HomeFragmentDirections
import kz.porcuon.movien.support.AbstractFragment

class ProfileFragment : AbstractFragment() {

    override val layoutId = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        btnLogout.setOnClickListener {
            clearSessionId()
            val directions = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
            Navigation.findNavController(it).navigate(directions)
        }
    }
}