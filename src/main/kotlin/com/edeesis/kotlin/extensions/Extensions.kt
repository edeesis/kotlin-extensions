package com.edeesis.kotlin.extensions

import java.util.Optional

fun <T> Optional<T>.toNullable(): T? = orElse(null)
