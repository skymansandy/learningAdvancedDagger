package dev.iamsandy.daggerlearning.ui.post

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import dev.iamsandy.daggerlearning.databinding.FragmentPostsBinding
import dev.iamsandy.daggerlearning.util.Resource
import dev.iamsandy.daggerlearning.viewmodels.ViewModelProviderFactory
import javax.inject.Inject

class PostsFragment : DaggerFragment() {

    private lateinit var binding: FragmentPostsBinding

    companion object {
        const val TAG = "PostsFragment"
    }

    @Inject
    lateinit var vmFactory: ViewModelProviderFactory
    private lateinit var vm: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, vmFactory).get(PostViewModel::class.java)
        vm.observePosts()
            .observe(this, Observer {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        Log.d(TAG, "Success ${it.data}")
                        val adapter = PostsRecyclerAdapter()
                        adapter.setPosts(it.data ?: emptyList())
                        binding.recyclerView.adapter = adapter
                    }
                    Resource.Status.ERROR -> {
                        Log.d(TAG, "Failure ${it.message}")
                    }
                    Resource.Status.LOADING -> {
                        Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        vm.searchPosts()
    }
}