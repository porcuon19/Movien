package kz.porcuon.movien.login

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.data.di.ServiceLocator
import kz.porcuon.domain.data.LoginParams
import kz.porcuon.domain.use_cases.LoginUseCase
import kz.porcuon.movien.support.AbstractViewModel

class LoginViewModel : AbstractViewModel() {

    private val loginUseCase = LoginUseCase(ServiceLocator.authenticationRepository)

    internal val viewState: MutableLiveData<LoginViewState> = MutableLiveData(LoginViewState.None)

    private fun handleLoginFailure(throwable: Throwable) {
        viewState.value = LoginViewState.HideLoading
        viewState.value = LoginViewState.ShowLoginError
    }

    fun login(username: String?, password: String?) {
        viewState.value = LoginViewState.ShowLoading
        if (username.isNullOrBlank() || password.isNullOrBlank()) {
            viewState.value = LoginViewState.HideLoading
            viewState.value = LoginViewState.ShowEmptyFieldsError
            return
        }
        scope.launch {
            loginUseCase(
                LoginParams(username, password),
                {
                    viewState.value = LoginViewState.HideLoading
                    viewState.value = LoginViewState.ShowHome
                    viewState.value = LoginViewState.None
                },
                ::handleLoginFailure
            )
        }
    }
}