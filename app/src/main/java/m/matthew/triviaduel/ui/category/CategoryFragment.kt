package m.matthew.triviaduel.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import m.matthew.triviaduel.R
import m.matthew.triviaduel.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {


    private lateinit var viewModel: CategoryViewModel
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var category: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.generalButton.setOnClickListener {
            category = R.string.general_knowledge.toString()
            goToGameFragment(category)
        }
        binding.entertainmentButton.setOnClickListener {
            category = R.string.entertainment.toString()
            goToGameFragment(category)
        }
        binding.scienceButton.setOnClickListener {
            category = R.string.science.toString()
            goToGameFragment(category)
        }
        binding.mythologyButton.setOnClickListener {
            category = R.string.mythology.toString()
            goToGameFragment(category)
        }
        binding.sportsButton.setOnClickListener {
            category = R.string.sports.toString()
            goToGameFragment(category)
        }
        binding.geographyButton.setOnClickListener {
            category = R.string.geography.toString()
            goToGameFragment(category)
        }
        binding.historyButton.setOnClickListener {
            category = R.string.history.toString()
            goToGameFragment(category)
        }
        binding.politicsButton.setOnClickListener {
            category = R.string.politics.toString()
            goToGameFragment(category)
        }
        binding.artButton.setOnClickListener {
            category = R.string.art.toString()
            goToGameFragment(category)
        }
        binding.celebritiesButton.setOnClickListener {
            category = R.string.celebrities.toString()
            goToGameFragment(category)
        }
        binding.animalsButton.setOnClickListener {
            category = R.string.animals.toString()
            goToGameFragment(category)
        }
        binding.vehiclesButton.setOnClickListener {
            category = R.string.vehicles.toString()
            goToGameFragment(category)
        }

        return binding.root
    }

    private fun goToGameFragment(category: String) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToGameFragment(category)
        findNavController().navigate(action)
    }

}