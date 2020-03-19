package dev.iamsandy.daggerlearning.di.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.iamsandy.daggerlearning.di.app.ViewModelKey
import dev.iamsandy.daggerlearning.ui.post.PostViewModel
import dev.iamsandy.daggerlearning.ui.profile.ProfileViewModel

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(profileViewModel: PostViewModel): ViewModel
}