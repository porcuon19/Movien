package kz.porcuon.movien.flow.login

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.domain.use_cases.LoginUseCase
import kz.porcuon.domain.use_cases.request_params.LoginParams
import kz.porcuon.movien.support.AbstractViewModel
import org.koin.core.inject

class LoginViewModel : AbstractViewModel() {

    private val loginUseCase: LoginUseCase by inject()

    val viewState: MutableLiveData<LoginViewState> = MutableLiveData(LoginViewState.None)

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