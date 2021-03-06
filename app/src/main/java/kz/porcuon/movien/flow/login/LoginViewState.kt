package kz.porcuon.movien.flow.login

sealed class LoginViewState {
    object None : LoginViewState()
    object ShowLoading : LoginViewState()
    object HideLoading : LoginViewState()
    object ShowEmptyFieldsError : LoginViewState()
    object ShowLoginError : LoginViewState()
    object ShowHome : LoginViewState()
}