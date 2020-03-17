package dev.iamsandy.daggerlearning.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.iamsandy.daggerlearning.PlayDumpApp
import dev.iamsandy.daggerlearning.R
import dev.iamsandy.daggerlearning.di.component.ActivityComponent
import dev.iamsandy.daggerlearning.di.component.DaggerActivityComponent
import dev.iamsandy.daggerlearning.model.Car
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent

    @Inject
    lateinit var car1: Car

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerActivityComponent.builder()
            .horsePower(13)
            .engineCapacity(150)
            .appComponent((application as PlayDumpApp).appComponent)
            .build()
            .inject(this)

        car1.drive()
        car2.drive()
    }
}
