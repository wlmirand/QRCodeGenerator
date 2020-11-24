package miranda.william.qrcodegenerator.services.db.dao

import androidx.room.*
import miranda.william.qrcodegenerator.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Dao for User
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM User LIMIT 1")
    fun get(): Flow<User?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Delete
    suspend fun delete(user: User)
}
