package dev.iamsandy.playdump.di.component

import dagger.BindsInstance
import dagger.Component
import dev.iamsandy.playdump.di.module.DieselEngineModule
import dev.iamsandy.playdump.di.module.WheelModule
import dev.iamsandy.playdump.di.scope.PerActivity
import dev.iamsandy.playdump.model.Car
import dev.iamsandy.playdump.ui.main.MainActivity
import javax.inject.Named

@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [WheelModule::class, DieselEngineModule::class]
)
interface ActivityComponent {
    fun getCar(): Car

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun horsePower(@Named("horsePower") horsePower: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("engineCapacity") engineCapacity: Int): Builder

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): ActivityComponent
    }
}