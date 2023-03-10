package com.radzhabov.data.model

data class User(
    var firstname: String,
    var lastname: String,
    var email: String
) {
    companion object {
        fun defaultUser() = User(firstname = "", lastname = "", email = "")
    }
}