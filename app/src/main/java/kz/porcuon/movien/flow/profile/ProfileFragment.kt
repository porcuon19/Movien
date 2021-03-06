package kz.porcuon.movien.flow.profile

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_profile.*
import kz.porcuon.domain.data.account.Account
import kz.porcuon.movien.R
import kz.porcuon.movien.flow.home.HomeFragmentDirections
import kz.porcuon.movien.support.AbstractFragment

class ProfileFragment : AbstractFragment() {

    private val profileViewModel: ProfileViewModel by lazy {
        ViewModelProviders.of(this).get(ProfileViewModel::class.java)
    }

    override val layoutId = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        profileViewModel.viewState.observe(
            viewLifecycleOwner,
            Observer { handleViewStateChange(it) }
        )
    }

    private fun handleViewStateChange(viewState: ProfileViewState) = when (viewState) {
        is ProfileViewState.ShowAccountDetails -> showAccountDetails(viewState.account)
        is ProfileViewState.Logout -> logout()
    }

    private fun setupUI() {
        btnLogout.setOnClickListener {
            profileViewModel.logout()
        }
    }

    private fun showAccountDetails(account: Account) {
        etId.setText(account.id.toString())
        etUsername.setText(account.username)
        etName.setText(account.name)
    }

    private fun logout() {
        val directions = HomeFragmentDirections.actionHomeFragmentToLoginFragment()
        Navigation.findNavController(view!!).navigate(directions)
    }
}