package com.artemissoftware.arexionmessages.ui.models

data class Prediction (val description: String, var fulfilled: Int = 0) {


    fun believe (): String{

        when(fulfilled){


            1 ->{
                return "fulfilled"
            }
            2 ->{
                return "Not fulfilled"
            }
            else ->{
                return ""
            }

        }

    }
}