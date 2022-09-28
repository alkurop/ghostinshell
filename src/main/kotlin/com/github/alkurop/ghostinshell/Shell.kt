package com.github.alkurop.ghostinshell

import java.util.concurrent.atomic.AtomicReference

class Shell<T>(ghost: T?) {
    val ghost: AtomicReference<T> = AtomicReference(ghost)

    fun get(): T? = ghost.getAndSet(null)

    companion object {
        fun <T> empty(): Shell<T> = Shell(null)
        fun <T> T?.toShell() = Shell(this)
    }
}