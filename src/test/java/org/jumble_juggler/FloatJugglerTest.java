/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package org.jumble_juggler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ThreadLocalRandom;
import org.jumble_juggler.exceptions.JumbleJugglerException;
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
    float random = ThreadLocalRandom.current().nextFloat();

    float result = assertDoesNotThrow(() -> FloatJuggler.generateRandomFloatSmallerThan(random));
    assertTrue(result < random);
  }

  @Test
  void testGenerateRandomFloatGreaterThan() {
    float random = ThreadLocalRandom.current().nextFloat();

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
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
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
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
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
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
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
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
  }

  @Test
  void testGenerateRandomFloatBetween_WhenMinGreaterThanMax_ThrowException() {
    float random = ThreadLocalRandom.current().nextFloat();
    float min = FloatJuggler.generateRandomFloatSmallerThan(random);
    float max = FloatJuggler.generateRandomFloatGreaterThan(random);

    float result = assertDoesNotThrow(() -> FloatJuggler.generateRandomFloatBetween(min, max));
    assertTrue(result >= min && result < max);
  }

  @Test
  void testGenerateRandomFloatBetween() {
    float random = ThreadLocalRandom.current().nextFloat();
    float min = FloatJuggler.generateRandomFloatGreaterThan(random);
    float max = FloatJuggler.generateRandomFloatSmallerThan(random);

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class, () -> FloatJuggler.generateRandomFloatBetween(min, max));
    assertEquals(
        "The minimum value given is "
            + min
            + ", but it must be smaller than "
            + "the maximum value given which is "
            + max
            + ".",
        exception.getMessage());
  }
}
