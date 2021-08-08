package com.artemissoftware.arexionmessages.ui

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artemissoftware.arexionmessages.ui.models.Prediction
import com.artemissoftware.arexionmessages.util.Event

class PredictionsViewModel : ViewModel() {

    val message = MutableLiveData<Prediction>()

    private val _predictions = MutableLiveData<List<Prediction>>()
    val predictions: LiveData<List<Prediction>> = _predictions

    private val _predicting  = MutableLiveData<Int>(View.GONE)
    val predicting: LiveData<Int> = _predicting


    private var listPrediction = mutableListOf<Prediction>()
    private var masterListPrediction = listOf<Prediction>(Prediction("Prediction number 1"), Prediction("Prediction number 2"), Prediction("Prediction number 3"))
    private var position = 0

    fun startVisions(){

        _predicting.value = View.VISIBLE


        Handler(Looper.getMainLooper()).postDelayed({

            if(masterListPrediction.size == position){
                _predicting.value = View.GONE
                return@postDelayed;
            }

            listPrediction.add(0, masterListPrediction[position])
            ++position
            _predictions.value = listPrediction
            _predicting.value = View.GONE
        }, 400)

    }


    fun sendMessage() {
        message.value = listPrediction.find { item-> item.fulfilled == 0}
        }

    fun fulfilled() {
        listPrediction.find { item-> item.description == message.value?.description }?.fulfilled = 1
        _predictions.value = listPrediction
    }

    fun notfulfilled() {
        listPrediction.find { item-> item.description == message.value?.description }?.fulfilled = 2
        _predictions.value = listPrediction
    }
}
