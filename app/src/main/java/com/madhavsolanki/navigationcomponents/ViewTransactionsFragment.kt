package com.madhavsolanki.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.madhavsolanki.navigationcomponents.databinding.FragmentHomeBinding
import com.madhavsolanki.navigationcomponents.databinding.FragmentViewTransactionsBinding


class ViewTransactionsFragment : Fragment() {

    private var _binding: FragmentViewTransactionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {


        }
    }
}