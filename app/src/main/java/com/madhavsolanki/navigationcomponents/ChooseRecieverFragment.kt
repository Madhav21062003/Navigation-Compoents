package com.madhavsolanki.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.madhavsolanki.navigationcomponents.databinding.FragmentChooseRecieverBinding
import com.madhavsolanki.navigationcomponents.databinding.FragmentHomeBinding


class ChooseRecieverFragment : Fragment() {

    private var _binding: FragmentChooseRecieverBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChooseRecieverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnNext.setOnClickListener {
                val navOption = NavOptions.Builder()
                    .setEnterAnim(R.anim.slide_in_right)
                    .setExitAnim(R.anim.slide_out_right)
                    .setPopEnterAnim(R.anim.slide_in_left)
                    .setPopExitAnim(R.anim.slide_out_left)
                    .build()
                val receiverName = etRecieverName.text.toString()

                // We send our data using Bundle
//                val args = Bundle()
//                args.putString("name", receiverName)

                val action = ChooseRecieverFragmentDirections.actionChooseRecieverFragmentToSendCashFragment(receiverName,200)
                findNavController().navigate(action, navOption)
            }

            btnCancel.setOnClickListener{
                val action = ChooseRecieverFragmentDirections.actionChooseRecieverFragmentToHomeFragment()
                findNavController().navigate(action )

            }

        }
    }
}
