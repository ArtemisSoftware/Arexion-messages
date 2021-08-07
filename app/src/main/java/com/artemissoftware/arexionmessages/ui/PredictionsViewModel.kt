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

    val message = MutableLiveData<String>()

    private val _predictions = MutableLiveData<Event<List<Prediction>>>()
    val predictions: LiveData<Event<List<Prediction>>> = _predictions

    private val _predicting  = MutableLiveData<Int>(View.GONE)
    val predicting: LiveData<Int> = _predicting

    fun startVisions(){

        _predicting.value = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({


            _predictions.value = Event(listOf(Prediction("My my my")))
            _predicting.value = View.GONE
        }, 4000)

    }


    fun sendMessage(text: String) {
        message.value = text
    }

    fun fulfilled() {
        _predictions.value = Event(listOf(Prediction("My my my", true), Prediction("lolo")))
    }
}
