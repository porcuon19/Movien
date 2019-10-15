package kz.porcuon.data.extensions

import retrofit2.Response

/*TODO implement proper error handling*/
internal fun <T> Response<T>.unwrap(): T {
//    if (!isSuccessful) {
//        throw NetworkResponseException(message(), code())
//    } else if (body()?.isSuccessful != true) {
//        throw BackendResponseException(body()?.message ?: "", body()?.errorCode ?: -1)
//    } else if (body()?.data == null) {
//        throw NullResponseException()
//    }
    return body()!!
}