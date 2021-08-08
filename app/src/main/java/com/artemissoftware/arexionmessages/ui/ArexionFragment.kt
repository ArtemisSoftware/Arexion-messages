package com.artemissoftware.arexionmessages.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arexionmessages.R
import com.artemissoftware.arexionmessages.databinding.FragmentArexionBinding
import com.artemissoftware.arexionmessages.ui.adapters.PredictionListAdapter
import com.artemissoftware.arexionmessages.ui.models.Prediction
import com.artemissoftware.arexionmessages.util.observeOnce
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
        binding.model = predictionsViewModel
        binding.lifecycleOwner = this

        setupRecyclerView()


        predictionsViewModel.predictions.observe(viewLifecycleOwner) {

            predictionListAdapter.submitList(it?.toMutableList())
            predictionsViewModel.sendMessage()

        }


        fab_start_predictions.setOnClickListener {
            predictionsViewModel.startVisions()
        }




    }



    private fun setupRecyclerView() {
        recyclerView.adapter = predictionListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}