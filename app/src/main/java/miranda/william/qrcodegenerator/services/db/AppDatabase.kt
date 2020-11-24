package miranda.william.qrcodegenerator.services.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import miranda.william.qrcodegenerator.model.User
import miranda.william.qrcodegenerator.services.db.dao.UserDao

/**
 * Database Definition
 */
@Database(
    entities = [
        User::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}