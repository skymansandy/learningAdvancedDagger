package dev.iamsandy.daggerlearning.ui.auth.model

class AuthResource<T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    companion object {
        fun <T> logout(data: T?): AuthResource<T> {
            return AuthResource(Status.NOT_AUTHENTICATED, data, null)
        }

        fun <T> authenticated(data: T?): AuthResource<T> {
            return AuthResource(Status.AUTHENTICATED, data, null)
        }

        fun <T> error(msg: String, data: T?): AuthResource<T> {
            return AuthResource(Status.ERROR, data, msg)
        }

        fun <T> loading(): AuthResource<T>? {
            return AuthResource(Status.LOADING, null, null)
        }
    }

    enum class Status {
        ERROR, AUTHENTICATED, NOT_AUTHENTICATED, LOADING
    }
}
