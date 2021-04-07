package m.matthew.triviaduel.ui.game

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import m.matthew.triviaduel.R
import m.matthew.triviaduel.databinding.GameFragmentBinding
import m.matthew.triviaduel.ui.home.HomeViewModel

class GameFragment : Fragment() {

    private val viewModel by viewModels<GameViewModel>()
    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = GameFragmentBinding.inflate(inflater, container, false)



        return binding.root
    }

}