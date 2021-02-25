package com.github.alkurop.ghostinshell

class Shell<T>(ghost: T?) {
    @Volatile
    var ghost: T?
        private set
        get() {
            if (!isPresent) return null
            synchronized(this) {
                if (!isPresent) return null
                isPresent = false

                val currentValue = field
                field = null
                return currentValue
            }
        }

    @Volatile
    private var isPresent: Boolean

    init {
        this.ghost = ghost
        this.isPresent = ghost != null
    }

    companion object {
        fun <T> empty(): Shell<T> = Shell(null)
    }
}