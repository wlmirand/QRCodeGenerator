package miranda.william.qrcodegenerator.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import miranda.william.qrcodegenerator.R
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Home Fragment
 */
class HomeFragment : Fragment() {

    /**
     * ViewModel
     */
    private val viewModel: HomeViewModel by viewModel()

    /**
     * OnCreateView
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /**
     * OnViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Navigate to the Register
        register.setOnClickListener { findNavController().navigate(HomeFragmentDirections.toRegisterFragment()) }

        //Lets see if we have an existing Barcode
        viewModel.code.observe(viewLifecycleOwner) {
            if (it != null) {
                register.visibility = View.GONE
                qrCode.visibility = View.VISIBLE
                qrCode.setImageBitmap(it)
            } else {
                register.visibility = View.VISIBLE
                qrCode.visibility = View.GONE
            }
        }
    }

}