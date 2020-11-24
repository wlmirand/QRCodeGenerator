package miranda.william.qrcodegenerator.services.db

import androidx.room.TypeConverter
import java.util.*

/**
 * Type Converters for Database
 */
class Converters {

    /**
     * Date para Long
     */
    @TypeConverter
    fun timestampToDate(value: Long) = Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date) = date.time
}