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

class IntegerJugglerTest {

  @Test
  void testGenerateRandomPositiveInt() {
    int result = Assertions.assertDoesNotThrow(IntegerJuggler::generateRandomPositiveInt);
    assertTrue(result >= 0);
  }

  @Test
  void testGenerateRandomNegativeInt() {
    int result = assertDoesNotThrow(IntegerJuggler::generateRandomNegativeInt);
    assertTrue(result < 0);
  }

  @Test
  void testGenerateRandomIntSmallerThan() {
    int random = ThreadLocalRandom.current().nextInt();

    int result = assertDoesNotThrow(() -> IntegerJuggler.generateRandomIntSmallerThan(random));
    assertTrue(result < random);
  }

  @Test
  void testGenerateRandomIntGreaterThan() {
    int random = ThreadLocalRandom.current().nextInt();

    int result = assertDoesNotThrow(() -> IntegerJuggler.generateRandomIntGreaterThan(random));
    assertTrue(result >= random);
  }

  @Test
  void testGenerateRandomPositiveIntGreaterThan() {
    int random = IntegerJuggler.generateRandomPositiveInt();

    int result =
        assertDoesNotThrow(() -> IntegerJuggler.generateRandomPositiveIntGreaterThan(random));
    assertTrue(result >= 0 && result >= random);
  }

  @Test
  void testGenerateRandomPositiveIntGreaterThan_WhenMaxIsNegative_ThrowException() {
    int random = IntegerJuggler.generateRandomNegativeInt();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> IntegerJuggler.generateRandomPositiveIntGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
  }

  @Test
  void testGenerateRandomPositiveIntSmallerThan() {
    int random = IntegerJuggler.generateRandomPositiveInt();

    int result =
        assertDoesNotThrow(() -> IntegerJuggler.generateRandomPositiveIntSmallerThan(random));
    assertTrue(result >= 0 && result < random);
  }

  @Test
  void testGenerateRandomPositiveIntSmallerThan_WhenMaxIsNegative_ThrowException() {
    int random = IntegerJuggler.generateRandomNegativeInt();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> IntegerJuggler.generateRandomPositiveIntSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeIntGreaterThan() {
    int random = IntegerJuggler.generateRandomNegativeInt();
    int result =
        assertDoesNotThrow(() -> IntegerJuggler.generateRandomNegativeIntGreaterThan(random));
    assertTrue(result < 0 && result >= random);
  }

  @Test
  void testGenerateRandomNegativeIntGreaterThan_WhenMaxIsPositive_ThrowException() {
    int random = IntegerJuggler.generateRandomPositiveInt();
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> IntegerJuggler.generateRandomNegativeIntGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeIntSmallerThan() {
    int random = IntegerJuggler.generateRandomNegativeInt();

    int result =
        assertDoesNotThrow(() -> IntegerJuggler.generateRandomNegativeIntSmallerThan(random));
    assertTrue(result < 0 && result < random);
  }

  @Test
  void testGenerateRandomNegativeIntSmallerThan_WhenMaxIsPositive_ThrowException() {
    int random = IntegerJuggler.generateRandomPositiveInt();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> IntegerJuggler.generateRandomNegativeIntSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
  }

  @Test
  void testGenerateRandomIntBetween_WhenMinGreaterThanMax_ThrowException() {
    int random = ThreadLocalRandom.current().nextInt();
    int min = IntegerJuggler.generateRandomIntSmallerThan(random);
    int max = IntegerJuggler.generateRandomIntGreaterThan(random);

    int result = assertDoesNotThrow(() -> IntegerJuggler.generateRandomIntBetween(min, max));
    assertTrue(result >= min && result < max);
  }

  @Test
  void testGenerateRandomIntBetween() {
    int random = ThreadLocalRandom.current().nextInt();
    int min = IntegerJuggler.generateRandomIntGreaterThan(random);
    int max = IntegerJuggler.generateRandomIntSmallerThan(random);

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class, () -> IntegerJuggler.generateRandomIntBetween(min, max));
    assertEquals(
        "The minimum value given is "
            + min
            + ", but it must be smaller than "
            + "the maximum value given which is "
            + max
            + ".",
        exception.getMessage());
  }

  @Test
  void generateRandomPositiveIntWithLength() {
    int length = 7;

    int result =
        assertDoesNotThrow(() -> IntegerJuggler.generateRandomPositiveIntWithLength(length));
    assertEquals(7, String.valueOf(result).length());
  }
}
