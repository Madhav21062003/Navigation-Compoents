package com.madhavsolanki.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.madhavsolanki.navigationcomponents.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        // Access views using binding object

        // Navigation Using Navigation ID's
        binding.apply {

            // Different Types of navigation through fragments
            btnViewBalance.setOnClickListener {

//                using nav graph
                navController.navigate(R.id.action_homeFragment_to_viewBalanceFragment)
            }

            btnViewTransactions.setOnClickListener {
                val navOption = NavOptions.Builder()
                    .setEnterAnim(R.anim.slide_in_right)
                    .setExitAnim(R.anim.slide_out_right)
                    .setPopEnterAnim(R.anim.slide_in_left)
                    .setPopExitAnim(R.anim.slide_out_left)
                    .build()
                navController.navigate(R.id.viewTransactionsFragment, null, navOption)
            }

            btnSendMoney.setOnClickListener {


                // Navigate Using action
                val action = HomeFragmentDirections.actionHomeFragmentToChooseRecieverFragment()
                navController.navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}