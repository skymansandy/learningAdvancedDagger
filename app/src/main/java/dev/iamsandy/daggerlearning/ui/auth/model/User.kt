package dev.iamsandy.daggerlearning.ui.auth.model

data class User(
    val website: String? = null,
    val address: Address? = null,
    val phone: String? = null,
    val name: String? = null,
    val company: Company? = null,
    val id: Int,
    val email: String? = null,
    val username: String? = null
)