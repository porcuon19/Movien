package kz.porcuon.data.sources.network

import kz.porcuon.data.entities.auth.RequestTokenEntity
import kz.porcuon.data.entities.auth.SessionEntity
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

private const val AUTHENTICATION_URL = "3/authentication"
private const val TOKEN_URL = "$AUTHENTICATION_URL/token"

interface AuthenticationApi {
    @GET("$TOKEN_URL/new")
    suspend fun getRequestToken(): Response<RequestTokenEntity>

    @FormUrlEncoded
    @POST("$TOKEN_URL/validate_with_login")
    suspend fun validateRequestToken(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("request_token") requestToken: String
    ): Response<RequestTokenEntity>

    @FormUrlEncoded
    @POST("$AUTHENTICATION_URL/session/new")
    suspend fun createSession(@Field("request_token") requestToken: String): Response<SessionEntity>
}