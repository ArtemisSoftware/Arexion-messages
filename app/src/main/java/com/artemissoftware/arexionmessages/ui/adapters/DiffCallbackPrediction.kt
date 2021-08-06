package com.artemissoftware.arexionmessages.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.artemissoftware.arexionmessages.ui.models.Prediction

class DiffCallbackPrediction : DiffUtil.ItemCallback<Prediction>() {
        override fun areItemsTheSame(oldItem: Prediction, newItem: Prediction) =
            oldItem.description == newItem.description

        override fun areContentsTheSame(oldItem: Prediction, newItem: Prediction) =
            oldItem == newItem

}