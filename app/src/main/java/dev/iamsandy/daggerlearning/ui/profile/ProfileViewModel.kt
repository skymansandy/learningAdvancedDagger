package dev.iamsandy.daggerlearning.ui.profile

import androidx.lifecycle.ViewModel
import dev.iamsandy.daggerlearning.di.app.SessionManager
import javax.inject.Inject

class ProfileViewModel @Inject constructor(val sessionManager: SessionManager) : ViewModel() {

}