package com.radzhabov.data.mappers

import com.radzhabov.data.entities.UserEntity
import com.radzhabov.data.model.User

fun UserEntity.mapUser() = User(
    firstname = this.firstname,
    lastname = this.lastname,
    email = this.email,
)

fun User.mapUserEntity() = UserEntity(
    firstname = this.firstname,
    lastname = this.lastname,
    email = this.email,
)