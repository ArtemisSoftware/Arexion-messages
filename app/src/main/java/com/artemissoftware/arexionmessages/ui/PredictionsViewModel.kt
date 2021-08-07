package com.artemissoftware.arexionmessages.ui

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artemissoftware.arexionmessages.ui.models.Prediction

class PredictionsViewModel : ViewModel() {

    val message = MutableLiveData<String>()

    val predictions = MutableLiveData<List<Prediction>>()
    val predicting  = MutableLiveData<Int>(View.GONE)

    fun startVisions(){

        predicting.value = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            predictions.value = listOf(Prediction("My my my"))
            predicting.value = View.GONE
        }, 4000)

    }


    fun sendMessage(text: String) {
        message.value = text
    }
}
