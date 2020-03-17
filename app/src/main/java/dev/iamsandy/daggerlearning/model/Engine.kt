package dev.iamsandy.daggerlearning.model

import android.util.Log

open class Engine constructor(private val horsePower: Int, private val engineCapacity: Int) {
    init {
        Log.d(
            "ENGINE",
            "Creating Engine with horsePower $horsePower, Engine capacity $engineCapacity.."
        )
    }

    open fun start() {
        Log.d("ENGINE", "Normal Engine started..")
    }
}