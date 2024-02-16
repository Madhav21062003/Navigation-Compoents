package com.madhavsolanki.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.madhavsolanki.navigationcomponents.databinding.FragmentConfirmDialogBinding
import com.madhavsolanki.navigationcomponents.databinding.FragmentHomeBinding


class ConfirmDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentConfirmDialogBinding? = null
    private val binding get() = _binding!!

    private val args:ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConfirmDialogBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val receiverName = args.receiverName
        val amount = args.amount

        binding.apply {
            tvMessage.text = "Do you want to send $amount to $receiverName?"

            btnYes.setOnClickListener {
                Toast.makeText(requireContext(), "$amount has been sent to $receiverName", Toast.LENGTH_SHORT).show()
                dismiss()
            }

            btnNo.setOnClickListener {
                dismiss()
            }
        }
    }
}