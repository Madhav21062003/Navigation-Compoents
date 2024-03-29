package com.madhavsolanki.navigationcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.madhavsolanki.navigationcomponents.databinding.FragmentNotificationsBinding
import com.madhavsolanki.navigationcomponents.databinding.FragmentSettingsBinding

class NotificationsFragment : Fragment() {

    private lateinit var _binding:FragmentNotificationsBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            lvNotifications.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,getNotifications())


        }

    }

    private fun getNotifications(): List<String> {
        val notifications = mutableListOf<String>()

        for (i in 1..20)
            notifications.add("Notification # $i")

        return notifications
    }
}