package dev.iamsandy.daggerlearning.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import dev.iamsandy.daggerlearning.databinding.FragmentProfileBinding
import dev.iamsandy.daggerlearning.viewmodels.ViewModelProviderFactory
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    private lateinit var binding: FragmentProfileBinding

    companion object {
        const val TAG = "ProfileFragment"
    }

    @Inject
    lateinit var vmFactory: ViewModelProviderFactory
    private lateinit var vm: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, vmFactory).get(ProfileViewModel::class.java)
        binding.user = vm.sessionManager.observeUser().value?.data
    }

}