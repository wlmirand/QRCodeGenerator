package miranda.william.qrcodegenerator.ui.home

import android.graphics.Bitmap
import android.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import miranda.william.qrcodegenerator.services.db.dao.UserDao
import kotlinx.coroutines.flow.map

/**
 * Home ViewModel
 */
class HomeViewModel(
    userDao: UserDao
) : ViewModel() {

    /**
     * Expose the User
     */
    val code = userDao.get().map {
        it?.let { generateQrCode(it.name, 512, 512) }
    }.asLiveData()

    /**
     * Generate the QR Code for a given String
     */
    private fun generateQrCode(code: String, width: Int, height: Int): Bitmap? {
        //Convert the Code to the Bit Matrix
        val bitMatrix = QRCodeWriter().encode(code, BarcodeFormat.QR_CODE, width, height)

        //Create an empty bitmap
        val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)

        //Fill it with the Matrix
        for (x in 0 until width) {
            for (y in 0 until height) {
                bmp.setPixel(
                    x,
                    y,
                    if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
                )
            }
        }

        return bmp
    }
}