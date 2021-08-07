package com.artemissoftware.arexionmessages.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.artemissoftware.arexionmessages.R
import kotlinx.android.synthetic.main.fragment_xenophon.*


class XenophonFragment : Fragment(R.layout.fragment_xenophon) {

    lateinit var predictionsViewModel: PredictionsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        predictionsViewModel = ViewModelProvider(requireActivity()).get(PredictionsViewModel::class.java)



        predictionsViewModel.message.observe(viewLifecycleOwner, Observer {
            txt_arexion_prediction.text = it
        })


        btn_believe.setOnClickListener {

            predictionsViewModel.fulfilled()
        }
    }
}