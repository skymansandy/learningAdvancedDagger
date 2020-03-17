package dev.iamsandy.playdump.model

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine @Inject constructor(
    @Named("horsePower") private val horsePower: Int,
    @Named("engineCapacity") private val engineCapacity: Int
) : Engine(horsePower,engineCapacity) {

    override fun start() {
        Log.d("ENGINE", "Petrol Engine started..")
    }
}