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

class LongJugglerTest {

  @Test
  void testGenerateRandomPositiveLong() {
    long result = Assertions.assertDoesNotThrow(LongJuggler::generateRandomPositiveLong);
    assertTrue(result >= 0L);
  }

  @Test
  void testGenerateRandomNegativeLong() {
    long result = assertDoesNotThrow(LongJuggler::generateRandomNegativeLong);
    assertTrue(result < 0L);
  }

  @Test
  void testGenerateRandomLongSmallerThan() {
    long random = ThreadLocalRandom.current().nextLong();

    long result = assertDoesNotThrow(() -> LongJuggler.generateRandomLongSmallerThan(random));
    assertTrue(result < random);
  }

  @Test
  void testGenerateRandomLongGreaterThan() {
    long random = ThreadLocalRandom.current().nextLong();

    long result = assertDoesNotThrow(() -> LongJuggler.generateRandomLongGreaterThan(random));
    assertTrue(result >= random);
  }

  @Test
  void testGenerateRandomPositiveLongGreaterThan() {
    long random = LongJuggler.generateRandomPositiveLong();

    long result =
        assertDoesNotThrow(() -> LongJuggler.generateRandomPositiveLongGreaterThan(random));
    assertTrue(result >= 0L && result >= random);
  }

  @Test
  void testGenerateRandomPositiveLongGreaterThan_WhenMaxIsNegative_ThrowException() {
    long random = LongJuggler.generateRandomNegativeLong();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> LongJuggler.generateRandomPositiveLongGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
  }

  @Test
  void testGenerateRandomPositiveLongSmallerThan() {
    long random = LongJuggler.generateRandomPositiveLong();

    long result =
        assertDoesNotThrow(() -> LongJuggler.generateRandomPositiveLongSmallerThan(random));
    assertTrue(result >= 0L && result < random);
  }

  @Test
  void testGenerateRandomPositiveLongSmallerThan_WhenMaxIsNegative_ThrowException() {
    long random = LongJuggler.generateRandomNegativeLong();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> LongJuggler.generateRandomPositiveLongSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be positive.", exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeLongGreaterThan() {
    long random = LongJuggler.generateRandomNegativeLong();

    long result =
        assertDoesNotThrow(() -> LongJuggler.generateRandomNegativeLongGreaterThan(random));
    assertTrue(result < 0L && result >= random);
  }

  @Test
  void testGenerateRandomNegativeLongGreaterThan_WhenMaxIsPositive_ThrowException() {
    long random = LongJuggler.generateRandomPositiveLong();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> LongJuggler.generateRandomNegativeLongGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeLongSmallerThan() {
    long random = LongJuggler.generateRandomNegativeLong();

    long result =
        assertDoesNotThrow(() -> LongJuggler.generateRandomNegativeLongSmallerThan(random));
    assertTrue(result < 0L && result < random);
  }

  @Test
  void testGenerateRandomNegativeLongSmallerThan_WhenMaxIsPositive_ThrowException() {
    long random = LongJuggler.generateRandomPositiveLong();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> LongJuggler.generateRandomNegativeLongSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be negative.", exception.getMessage());
  }

  @Test
  void testGenerateRandomLongBetween_WhenMinGreaterThanMax_ThrowException() {
    long random = ThreadLocalRandom.current().nextLong();
    long min = LongJuggler.generateRandomLongSmallerThan(random);
    long max = LongJuggler.generateRandomLongGreaterThan(random);

    long result = assertDoesNotThrow(() -> LongJuggler.generateRandomLongBetween(min, max));
    assertTrue(result >= min && result < max);
  }

  @Test
  void testGenerateRandomLongBetween() {
    long random = ThreadLocalRandom.current().nextLong();
    long min = LongJuggler.generateRandomLongGreaterThan(random);
    long max = LongJuggler.generateRandomLongSmallerThan(random);

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class, () -> LongJuggler.generateRandomLongBetween(min, max));
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
  void generateRandomPositiveLongWithLength() {
    long length = 5L;

    long result =
        assertDoesNotThrow(() -> LongJuggler.generateRandomPositiveLongWithLength(length));
    assertEquals(5, String.valueOf(result).length());
  }
}
