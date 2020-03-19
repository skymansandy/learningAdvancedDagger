package dev.iamsandy.daggerlearning.di.main

import dagger.Module
import dagger.Provides
import dev.iamsandy.daggerlearning.ui.post.PostsApi
import dev.iamsandy.daggerlearning.ui.post.PostsRecyclerAdapter
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    fun providePostsApi(retrofit: Retrofit): PostsApi {
        return retrofit.create(PostsApi::class.java)
    }

    @Provides
    fun providePostsRecyclerAdapter(): PostsRecyclerAdapter {
        return PostsRecyclerAdapter()
    }
}