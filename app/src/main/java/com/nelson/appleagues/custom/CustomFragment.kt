package com.nelson.appleagues.custom

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.nelson.appleagues.databinding.CustomFragmentBinding


class CustomFragment : Fragment() {

    private lateinit var binding: CustomFragmentBinding
    private val args: CustomFragmentArgs by navArgs()
    private lateinit var viewModel: CustomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CustomFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CustomViewModel::class.java)
        prepareUI()
    }

    private fun prepareUI() = with(binding) {

        nameTextView.setText(args.name)
        stadium.setText(args.namestadium)
        description.setText(args.description)

        Glide.with(requireActivity())
            .load(args.imegenteam)
            .into(roundedImage)

        Glide.with(requireActivity())
            .load(args.imegenstadium)
            .transform(CircleCrop())
            .into(roundedStadium)

        Glide.with(requireActivity())
            .load(args.imegeteamJersey)
            .transform(CircleCrop())
            .into(coat)
    }

}