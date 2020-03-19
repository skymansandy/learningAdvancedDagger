package dev.iamsandy.daggerlearning.di.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.iamsandy.daggerlearning.ui.post.PostsFragment
import dev.iamsandy.daggerlearning.ui.profile.ProfileFragment

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun provideProfileFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun providePostsFragment(): PostsFragment
}