package kz.porcuon.data.sources.preferences

import com.orhanobut.hawk.Hawk

private const val PREFS_SESSION_ID = "prefs_session_id"
private const val PREFS_ACCOUNT_ID = "prefs_account_id"

/**
 * Session prefs
 */

fun setSessionId(sessionId: String) {
    Hawk.put(PREFS_SESSION_ID, sessionId)
}

fun getSessionId(): String? {
    return Hawk.get(PREFS_SESSION_ID)
}

fun clearSessionId() {
    Hawk.delete(PREFS_SESSION_ID)
}

fun isSessionIdPresent(): Boolean = Hawk.contains(PREFS_SESSION_ID)

/**
 * Account prefs
 */

fun setAccountId(accountId: Int) {
    Hawk.put(PREFS_ACCOUNT_ID, accountId)
}

fun getAccountId(): Int {
    return Hawk.get(PREFS_ACCOUNT_ID)
}

fun clearAccountId() {
    Hawk.delete(PREFS_ACCOUNT_ID)
}

fun isAccountIdPresent(): Boolean = Hawk.contains(PREFS_ACCOUNT_ID)