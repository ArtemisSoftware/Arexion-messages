package com.artemissoftware.arexionmessages.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.arexionmessages.R
import com.artemissoftware.arexionmessages.ui.adapters.PredictionListAdapter
import com.artemissoftware.arexionmessages.ui.models.Prediction
import kotlinx.android.synthetic.main.fragment_arexion.*


class ArexionFragment : Fragment(R.layout.fragment_arexion) {


    private val predictionListAdapter by lazy { PredictionListAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        predictionListAdapter.submitList(listOf(Prediction("Prediction 2"), Prediction("Prediction 1")))

    }



    private fun setupRecyclerView() {
        recyclerView.adapter = predictionListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}