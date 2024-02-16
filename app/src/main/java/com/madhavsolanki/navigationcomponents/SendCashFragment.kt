package com.madhavsolanki.navigationcomponents

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.madhavsolanki.navigationcomponents.databinding.FragmentSendCashBinding


class SendCashFragment : Fragment() {

    private var _binding: FragmentSendCashBinding? = null
    private val binding get() = _binding!!
    val args    : SendCashFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSendCashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            etAmount.setText(SampleData.defaultAmount.value.toString())
            SampleData.defaultAmount.observe(viewLifecycleOwner){
                etAmount.setText(it.toString()  )
            }
//            val receiverName = arguments?.getString("name")

            // With null safety using safeargs
            val receiverName = args.receiverName
            val amount = args.amount
            tvReciever.text = "Send Cash to $receiverName\n$amount"



            sendBtn.setOnClickListener {

                if (etAmount.text.toString().isEmpty()){
                    Toast.makeText(requireContext(), "Enter some amount", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val amount = etAmount.text.toString().toLong()
                val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(receiverName, amount.toString())
                findNavController().navigate(action)
            }

            doneBtn.setOnClickListener {
                val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
                findNavController().navigate(action)
            }

            cancelBtn.setOnClickListener {
                findNavController().popBackStack(R.id.homeFragment, true)
            }
        }

    }


}