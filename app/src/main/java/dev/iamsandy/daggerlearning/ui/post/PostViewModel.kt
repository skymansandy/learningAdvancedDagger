package dev.iamsandy.daggerlearning.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import dev.iamsandy.daggerlearning.di.app.SessionManager
import dev.iamsandy.daggerlearning.ui.post.model.UserPost
import dev.iamsandy.daggerlearning.util.Resource
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class PostViewModel @Inject constructor(
    val sessionManager: SessionManager,
    private val postsApi: PostsApi
) : ViewModel() {

    private val posts = MediatorLiveData<Resource<List<UserPost>>>()

    fun observePosts(): LiveData<Resource<List<UserPost>>> {
        return posts
    }

    fun searchPosts() {
        posts.value = Resource.loading()
        val source = queryUserPosts("1")
        posts.addSource(queryUserPosts("1")) {
            posts.value = it
            posts.removeSource(source)
        }
    }

    private fun queryUserPosts(userId: String): LiveData<Resource<List<UserPost>>> {
        return LiveDataReactiveStreams
            .fromPublisher(
                postsApi.getPostsFor(userId)
                    .onErrorReturn {
                        val post = UserPost(id = -1)
                        val posts: ArrayList<UserPost> = ArrayList()
                        posts.add(post)
                        return@onErrorReturn posts
                    }.map {
                        if (it.isNotEmpty()) {
                            if (it[0].id === -1) {
                                return@map Resource.error("Something went wrong", it)
                            }
                        }
                        return@map Resource.success(it)
                    }
                    .subscribeOn(Schedulers.io())
            )
    }
}