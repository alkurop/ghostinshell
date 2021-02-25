package com.github.alkurop.ghostinshell

import org.junit.Test
import kotlin.test.assertEquals

internal class ShellTest {

    private val testGhost = "ghost"

    @Test
    fun `first call to nonempty shell returns ghost`() {
        val shell = Shell(testGhost)
        assertEquals( testGhost, shell.ghost)
    }

    @Test
    fun `second call to nonempty ghost returns null`() {
        val shell = Shell(testGhost)
        shell.ghost
        assertEquals(null, shell.ghost)
    }

    @Test
    fun `first call to empty shell returns null`() {
        val shell = Shell.empty<String>()
        assertEquals(null, shell.ghost)
    }
}