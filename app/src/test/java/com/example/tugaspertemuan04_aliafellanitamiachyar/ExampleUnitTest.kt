package com.example.tugaspertemuan04_aliafellanitamiachyar

import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun validation_logic_isCorrect() {
        val name = "Alia Fellanitami Achyar"
        val nim = "0102523010"
        val email = "alia.achyar@student.uai.ac.id"
        val isAgreed = true

        val isNameValid = name.trim().length >= 3
        val isNimValid = nim.trim().length == 10 && nim.trim().all { it.isDigit() }
        val isEmailValid = email.trim().contains("@") && email.trim().contains(".") && email.trim().length >= 6
        val isFormValid = isNameValid && isNimValid && isEmailValid && isAgreed

        assertTrue(isNameValid)
        assertTrue(isNimValid)
        assertTrue(isEmailValid)
        assertTrue(isFormValid)
    }
}