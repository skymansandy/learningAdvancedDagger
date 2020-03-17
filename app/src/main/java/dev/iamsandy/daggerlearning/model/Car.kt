package dev.iamsandy.daggerlearning.model

import android.util.Log
import dev.iamsandy.daggerlearning.di.scope.PerActivity
import javax.inject.Inject

@PerActivity
class Car @Inject constructor(
    private val driver: Driver,
    private val wheels: Wheels,
    private val engine: Engine
) {

    init {
        Log.d("WHEELS", "Installing Wheels..")
        Log.d("ENGINE", "Installing Engine..")
        Log.d("CAR", "Assembling Car..")
    }

    fun drive() {
        engine.start()
        Log.d("CAR", "Vroom!")
    }

    @Inject
    fun carPaint() {
        Log.d("CAR", "Paining..")
    }

    @Inject
    fun carConfigure() {
        Log.d("CAR", "Configuring..")
    }
}