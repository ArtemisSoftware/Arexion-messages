package com.artemissoftware.arexionmessages.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arexionmessages.R
import com.artemissoftware.arexionmessages.databinding.FragmentArexionBinding
import com.artemissoftware.arexionmessages.ui.adapters.PredictionListAdapter
import com.artemissoftware.arexionmessages.ui.models.Prediction
import kotlinx.android.synthetic.main.fragment_arexion.*


class ArexionFragment : Fragment(R.layout.fragment_arexion) {

    lateinit var predictionsViewModel: PredictionsViewModel

    private val predictionListAdapter by lazy { PredictionListAdapter() }


    private var _binding: FragmentArexionBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        predictionsViewModel = ViewModelProvider(requireActivity()).get(PredictionsViewModel::class.java)

        _binding = FragmentArexionBinding.bind(view)
        binding.lifecycleOwner = this
        binding.model = predictionsViewModel

        setupRecyclerView()

        predictionsViewModel.startVisions()

        predictionsViewModel.predictions.observe(viewLifecycleOwner) {
            predictionListAdapter.submitList(it)

            predictionsViewModel.sendMessage(it[0].description)
        }




    }



    private fun setupRecyclerView() {
        recyclerView.adapter = predictionListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}