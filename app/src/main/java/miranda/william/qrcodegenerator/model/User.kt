package miranda.william.qrcodegenerator.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Model for the User
 */
@Entity
data class User(
    @PrimaryKey val id: String,
    val name: String,
    val address: String
)