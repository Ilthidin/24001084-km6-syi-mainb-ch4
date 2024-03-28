package com.example.mainb.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mainb.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEdit.setOnClickListener{
            binding.tfName.isEnabled = !binding.tfName.isEnabled
            binding.tfUsername.isEnabled = !binding.tfUsername.isEnabled
            binding.tfEmail.isEnabled = !binding.tfEmail.isEnabled
            binding.tfPhone.isEnabled = !binding.tfPhone.isEnabled
        }
    }
}