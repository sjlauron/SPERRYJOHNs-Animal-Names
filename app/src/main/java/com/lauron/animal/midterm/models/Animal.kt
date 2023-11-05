package com.lauron.animal.midterm.models

import java.io.Serializable

data class Animal(
    val name: String,
    val description: String,
    var isBlocked: Boolean = false
): Serializable
