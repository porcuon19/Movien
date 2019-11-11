package kz.porcuon.data

import com.orhanobut.hawk.Hawk

private const val SESSION_ID = "user_session_id"

fun setSessionId(sessionId: String) {
    Hawk.put(SESSION_ID, sessionId)
}

fun getSessionId(): String {
    return Hawk.get(SESSION_ID)
}

fun clearSessionId() {
    Hawk.delete(SESSION_ID)
}

fun isSessionIdPresent(): Boolean = Hawk.contains(SESSION_ID)