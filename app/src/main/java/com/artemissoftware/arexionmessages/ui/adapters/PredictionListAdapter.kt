package com.artemissoftware.arexionmessages.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.arexionmessages.databinding.ItemPredictionBinding
import com.artemissoftware.arexionmessages.ui.models.Prediction

class PredictionListAdapter() : ListAdapter<Prediction, PredictionListAdapter.PredictionViewHolder>(DiffCallbackPrediction()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PredictionViewHolder {
        val binding = ItemPredictionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PredictionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PredictionViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class PredictionViewHolder(private val binding: ItemPredictionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(prediction: Prediction) {
            binding.apply {

                setPrediction(prediction)
                executePendingBindings()

            }
        }
    }

}
