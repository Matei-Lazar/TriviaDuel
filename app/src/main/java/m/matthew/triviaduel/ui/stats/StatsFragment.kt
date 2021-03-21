package m.matthew.triviaduel.ui.stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import m.matthew.triviaduel.R
import m.matthew.triviaduel.databinding.FragmentHomeBinding
import m.matthew.triviaduel.databinding.FragmentStatsBinding

class StatsFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentStatsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }
}