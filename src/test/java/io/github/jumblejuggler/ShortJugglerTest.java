/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler;

import static org.junit.jupiter.api.Assertions.*;

import io.github.jumblejuggler.exceptions.JumbleJugglerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShortJugglerTest {

  @Test
  void testGenerateRandomPositiveShort() {
    short result = assertDoesNotThrow(ShortJuggler::generateRandomPositiveShort);
    assertTrue(result >= 0);
  }

  @Test
  void testGenerateRandomNegativeShort() {
    short result = assertDoesNotThrow(ShortJuggler::generateRandomNegativeShort);
    assertTrue(result < 0);
  }

  @Test
  void testGenerateRandomShortSmallerThan() {
    short random = ShortJuggler.generateRandomShort();

    short result =
        Assertions.assertDoesNotThrow(() -> ShortJuggler.generateRandomShortSmallerThan(random));
    assertTrue(result < random);
  }

  @Test
  void testGenerateRandomShortGreaterThan() {
    short random = ShortJuggler.generateRandomShort();

    short result =
        Assertions.assertDoesNotThrow(() -> ShortJuggler.generateRandomShortGreaterThan(random));
    assertTrue(result >= random);
  }

  @Test
  void testGenerateRandomPositiveShortGreaterThan() {
    short random = ShortJuggler.generateRandomPositiveShort();

    short result =
        Assertions.assertDoesNotThrow(
            () -> ShortJuggler.generateRandomPositiveShortGreaterThan(random));
    assertTrue(result >= 0 && result >= random);
  }

  @Test
  void testGenerateRandomPositiveShortGreaterThan_WhenMaxIsNegative_ThrowException() {
    short random = ShortJuggler.generateRandomNegativeShort();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> ShortJuggler.generateRandomPositiveShortGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
  }

  @Test
  void testGenerateRandomPositiveShortSmallerThan() {
    short random = ShortJuggler.generateRandomPositiveShort();

    short result =
        Assertions.assertDoesNotThrow(
            () -> ShortJuggler.generateRandomPositiveShortSmallerThan(random));
    assertTrue(result >= 0 && result < random);
  }

  @Test
  void testGenerateRandomPositiveShortSmallerThan_WhenMaxIsNegative_ThrowException() {
    short random = ShortJuggler.generateRandomNegativeShort();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> ShortJuggler.generateRandomPositiveShortSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeShortGreaterThan() {
    short random = ShortJuggler.generateRandomNegativeShort();
    short result =
        Assertions.assertDoesNotThrow(
            () -> ShortJuggler.generateRandomNegativeShortGreaterThan(random));
    assertTrue(result < 0 && result >= random);
  }

  @Test
  void testGenerateRandomNegativeShortGreaterThan_WhenMaxIsPositive_ThrowException() {
    short random = ShortJuggler.generateRandomPositiveShort();
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> ShortJuggler.generateRandomNegativeShortGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeShortSmallerThan() {
    short random = ShortJuggler.generateRandomNegativeShort();

    short result =
        Assertions.assertDoesNotThrow(
            () -> ShortJuggler.generateRandomNegativeShortSmallerThan(random));
    assertTrue(result < 0 && result < random);
  }

  @Test
  void testGenerateRandomNegativeShortSmallerThan_WhenMaxIsPositive_ThrowException() {
    short random = ShortJuggler.generateRandomPositiveShort();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> ShortJuggler.generateRandomNegativeShortSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
  }

  @Test
  void testGenerateRandomShortBetween_WhenMinGreaterThanMax_ThrowException() {
    short random = ShortJuggler.generateRandomShort();
    short min = ShortJuggler.generateRandomShortSmallerThan(random);
    short max = ShortJuggler.generateRandomShortGreaterThan(random);

    short result =
        Assertions.assertDoesNotThrow(() -> ShortJuggler.generateRandomShortBetween(min, max));
    assertTrue(result >= min && result < max);
  }

  @Test
  void testGenerateRandomShortBetween() {
    short random = ShortJuggler.generateRandomShort();
    short min = ShortJuggler.generateRandomShortGreaterThan(random);
    short max = ShortJuggler.generateRandomShortSmallerThan(random);

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class, () -> ShortJuggler.generateRandomShortBetween(min, max));
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
