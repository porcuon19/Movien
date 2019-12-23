package kz.porcuon.movien.flow.profile

import kz.porcuon.domain.data.account.Account

sealed class ProfileViewState {
    class ShowAccountDetails(val account: Account) : ProfileViewState()
}