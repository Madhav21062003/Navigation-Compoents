package com.madhavsolanki.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.madhavsolanki.navigationcomponents.databinding.FragmentHomeBinding
import com.madhavsolanki.navigationcomponents.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            etDefaultAmt.setText(SampleData.defaultAmount.value.toString())

            btnSaveDefaultAmt.setOnClickListener {
                val defaultAmount = etDefaultAmt.text.toString().toLong()
                SampleData.defaultAmount.value = defaultAmount
            }

            btnAboutApp.setOnClickListener {
                val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
                findNavController().navigate(action)
            }
        }
    }
}