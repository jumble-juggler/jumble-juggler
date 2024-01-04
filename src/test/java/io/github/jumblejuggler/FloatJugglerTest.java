/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.jumblejuggler.exceptions.JumbleJugglerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FloatJugglerTest {

  @Test
  void testGenerateRandomPositiveFloat() {
    float result = Assertions.assertDoesNotThrow(FloatJuggler::generateRandomPositiveFloat);
    assertTrue(result >= 0);
  }

  @Test
  void testGenerateRandomNegativeFloat() {
    float result = assertDoesNotThrow(FloatJuggler::generateRandomNegativeFloat);
    assertTrue(result < 0);
  }

  @Test
  void testGenerateRandomFloatSmallerThan() {
    float random = FloatJuggler.generateRandomFloat();

    float result = assertDoesNotThrow(() -> FloatJuggler.generateRandomFloatSmallerThan(random));
    assertTrue(result < random);
  }

  @Test
  void testGenerateRandomFloatGreaterThan() {
    float random = FloatJuggler.generateRandomFloat();

    float result = assertDoesNotThrow(() -> FloatJuggler.generateRandomFloatGreaterThan(random));
    assertTrue(result >= random);
  }

  @Test
  void testGenerateRandomPositiveFloatGreaterThan() {
    float random = FloatJuggler.generateRandomPositiveFloat();

    float result =
        assertDoesNotThrow(() -> FloatJuggler.generateRandomPositiveFloatGreaterThan(random));
    assertTrue(result >= 0 && result >= random);
  }

  @Test
  void testGenerateRandomPositiveFloatGreaterThan_WhenMaxIsNegative_ThrowException() {
    float random = FloatJuggler.generateRandomNegativeFloat();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> FloatJuggler.generateRandomPositiveFloatGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly positive.",
        exception.getMessage());
  }

  @Test
  void testGenerateRandomPositiveFloatSmallerThan() {
    float random = FloatJuggler.generateRandomPositiveFloat();

    float result =
        assertDoesNotThrow(() -> FloatJuggler.generateRandomPositiveFloatSmallerThan(random));
    assertTrue(result >= 0 && result < random);
  }

  @Test
  void testGenerateRandomPositiveFloatSmallerThan_WhenMaxIsNegative_ThrowException() {
    float random = FloatJuggler.generateRandomNegativeFloat();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> FloatJuggler.generateRandomPositiveFloatSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly positive.",
        exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeFloatGreaterThan() {
    float random = FloatJuggler.generateRandomNegativeFloat();
    float result =
        assertDoesNotThrow(() -> FloatJuggler.generateRandomNegativeFloatGreaterThan(random));
    assertTrue(result < 0 && result >= random);
  }

  @Test
  void testGenerateRandomNegativeFloatGreaterThan_WhenMaxIsPositive_ThrowException() {
    float random = FloatJuggler.generateRandomPositiveFloat();
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> FloatJuggler.generateRandomNegativeFloatGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly negative.",
        exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeFloatSmallerThan() {
    float random = FloatJuggler.generateRandomNegativeFloat();

    float result =
        assertDoesNotThrow(() -> FloatJuggler.generateRandomNegativeFloatSmallerThan(random));
    assertTrue(result < 0 && result < random);
  }

  @Test
  void testGenerateRandomNegativeFloatSmallerThan_WhenMaxIsPositive_ThrowException() {
    float random = FloatJuggler.generateRandomPositiveFloat();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> FloatJuggler.generateRandomNegativeFloatSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly negative.",
        exception.getMessage());
  }
}
