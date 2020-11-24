package miranda.william.qrcodegenerator.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.*
import miranda.william.qrcodegenerator.databinding.FragmentRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Register Fragment
 */
class RegisterFragment : Fragment() {

    /**
     * ViewModel
     */
    private val viewModel: RegisterViewModel by viewModel()

    /**
     * Binding Layout
     */
    private lateinit var binding: FragmentRegisterBinding

    /**
     * OnCreateView
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    /**
     * OnViewCreated
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Invoke the ViewModel passing the Binding values
        fab.setOnClickListener {
            viewModel.save(binding.name, binding.address) {
                findNavController().navigateUp()
            }
        }
    }
}