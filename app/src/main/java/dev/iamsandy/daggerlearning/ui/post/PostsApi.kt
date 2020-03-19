package dev.iamsandy.daggerlearning.ui.post

import dev.iamsandy.daggerlearning.ui.post.model.UserPost
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsApi {

    @GET("/posts")
    fun getPostsFor(@Query("userId") userId: String): Flowable<List<UserPost>>
}