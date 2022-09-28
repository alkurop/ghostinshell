package com.github.alkurop.ghostinshell

import java.util.concurrent.atomic.AtomicReference

class Shell<T>(ghost: T?) {
    private val refHolder: AtomicReference<T> = AtomicReference(ghost)
    val ghost: T? = refHolder.getAndSet(null)

    companion object {
        fun <T> empty(): Shell<T> = Shell(null)
        fun <T> T?.toShell() = Shell(this)
    }
}