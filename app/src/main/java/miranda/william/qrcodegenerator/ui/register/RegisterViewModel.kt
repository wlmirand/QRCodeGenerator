package miranda.william.qrcodegenerator.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import miranda.william.qrcodegenerator.model.User
import miranda.william.qrcodegenerator.services.db.dao.UserDao
import kotlinx.coroutines.launch
import java.util.*

class RegisterViewModel(
    private val userDao: UserDao
) : ViewModel() {

    /**
     * Save the User
     */
    fun save(name: String?, address: String?, result: () -> Unit) {
        //Bad fields
        if (name.isNullOrBlank() || address.isNullOrBlank()) {
            return
        }

        //Now we can create the object and save
        viewModelScope.launch {
            val user = User(
                id = UUID.randomUUID().toString(),
                name = name,
                address = address
            )

            val rowId = userDao.insert(user)
            result()
        }
    }
}
