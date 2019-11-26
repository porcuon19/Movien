package kz.porcuon.data.entities.account

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kz.porcuon.domain.data.account.Account
import java.io.Serializable

@Entity(tableName = "account")
class AccountEntity : Serializable {
    @PrimaryKey
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("username")
    var username: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("include_adult")
    var includeAdult: Boolean = false
}

fun AccountEntity.toData(): Account {
    val entity = this
    return Account().apply {
        id = entity.id
        username = entity.username
        name = entity.name
        includeAdult = entity.includeAdult
    }
}

fun Account.toEntity(): AccountEntity {
    val data = this
    return AccountEntity().apply {
        id = data.id
        username = data.username
        name = data.name
        includeAdult = data.includeAdult
    }
}