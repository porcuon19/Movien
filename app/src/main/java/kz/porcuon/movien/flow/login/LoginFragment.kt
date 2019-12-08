package kz.porcuon.movien.flow.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import kz.porcuon.movien.R
import kz.porcuon.movien.support.AbstractFragment

class LoginFragment : AbstractFragment() {

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override val layoutId = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loginViewModel.viewState.observe(
            viewLifecycleOwner,
            Observer { handleViewStateChange(it) })
    }

    private fun setupUI() {
        btnLogin.setOnClickListener {
            loginViewModel.login(
                etUsername.text.toString(),
                etPassword.text.toString()
            )
        }
        tvSignUp.setOnClickListener {
            navigateToRegistration()
        }
    }

    private fun handleViewStateChange(viewState: LoginViewState) = when (viewState) {
        is LoginViewState.ShowLoading -> showLoading()
        is LoginViewState.HideLoading -> hideLoading()
        is LoginViewState.ShowEmptyFieldsError -> showEmptyFieldsError()
        is LoginViewState.ShowLoginError -> showLoginError()
        is LoginViewState.ShowHome -> navigateToHome()
        is LoginViewState.None -> { }
    }

    private fun showLoading() {
        pbLogin.visibility = View.VISIBLE
        btnLogin.apply {
            alpha = 0.7F
            isClickable = false
            text = null
        }
    }

    private fun hideLoading() {
        pbLogin.visibility = View.INVISIBLE
        btnLogin.apply {
            alpha = 1.0F
            isClickable = true
            text = getString(R.string.login_login)
        }
    }

    private fun showEmptyFieldsError() {
        layoutUsername.error = getString(R.string.login_field_is_empty)
        layoutPassword.error = getString(R.string.login_field_is_empty)
    }

    private fun showLoginError() {
        Toast.makeText(context, getString(R.string.login_invalid_credentials), Toast.LENGTH_SHORT).show()
    }

    private fun navigateToHome() {
        val directions = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        Navigation.findNavController(view!!).navigate(directions)
    }

    private fun navigateToRegistration() {
        val directions = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        Navigation.findNavController(view!!).navigate(directions)
    }
}