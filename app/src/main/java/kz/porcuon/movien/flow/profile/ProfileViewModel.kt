package kz.porcuon.movien.flow.profile

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kz.porcuon.data.sources.preferences.getAccountId
import kz.porcuon.domain.data.account.Account
import kz.porcuon.domain.use_cases.UseCase
import kz.porcuon.domain.use_cases.account.GetAccountDetailsUseCase
import kz.porcuon.domain.use_cases.auth.LogoutUseCase
import kz.porcuon.movien.support.AbstractViewModel
import org.koin.core.inject

class ProfileViewModel : AbstractViewModel() {
    private val getAccountDetailsUseCase: GetAccountDetailsUseCase by inject()
    private val logoutUseCase: LogoutUseCase by inject()

    val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()

    init {
        getAccountDetails()
    }

    private fun getAccountDetails() {
        scope.launch {
            getAccountDetailsUseCase(
                getAccountId(),
                ::handleGetAccountDetailsSuccess,
                ::handleGetAccountDetailsFailure
            )
        }
    }

    private fun handleGetAccountDetailsSuccess(account: Account) {
        viewState.value = ProfileViewState.ShowAccountDetails(account)
    }

    private fun handleGetAccountDetailsFailure(throwable: Throwable) {
        /*TODO add error handling*/
    }

    fun logout() {
        scope.launch {
            logoutUseCase(
                UseCase.None,
                { viewState.value = ProfileViewState.Logout },
                { /*TODO add error handling*/ }
            )
        }
    }
}