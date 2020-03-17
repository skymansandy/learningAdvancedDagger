package dev.iamsandy.playdump.model

import android.util.Log
import javax.inject.Inject

class Wheels @Inject constructor(val rims: Rims?, val tyres: Tyres) {
    init {
        Log.d("WHEELS", "Installing Rims..")
        Log.d("WHEELS", "Installing Tyres..")
        Log.d("WHEELS", "Creating Wheels..")
    }
}