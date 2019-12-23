package kz.porcuon.domain.data.account

class Account(
    val id: Int
) {
    var username: String? = null
    var name: String? = null
    var includeAdult: Boolean = false
}