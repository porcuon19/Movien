package kz.porcuon.data.sources.network

import kz.porcuon.data.entities.account.AccountEntity
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

private const val ACCOUNT_URL = "3/account"

interface AccountApi {
    @GET(ACCOUNT_URL)
    suspend fun getAccountDetails(): Response<AccountEntity>

    @GET("$ACCOUNT_URL/{accountId}/favorite/movies")
    suspend fun getFavoriteMovies(accountId: Int)

    @FormUrlEncoded
    @POST("$ACCOUNT_URL/{accountId}/favorite")
    suspend fun markMovieAsFavorite(
        accountId: Int,
        @Field("media_id") mediaId: Int,
        @Field("favorite") favorite: Boolean,
        @Field("media_type") mediaType: String = "movie"
    )
}