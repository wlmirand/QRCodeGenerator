package miranda.william.qrcodegenerator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import miranda.william.qrcodegenerator.R

/**
 * Main Activity
 */
class MainActivity : AppCompatActivity() {

    /**
     * AppBar Configuration
     */
    private lateinit var appBarConfiguration: AppBarConfiguration

    /**
     * OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setup the Action Bar
        setSupportActionBar(toolbar)

        //Setup the Navigation
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment_home
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    /**
     * OnNavigateUp
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}