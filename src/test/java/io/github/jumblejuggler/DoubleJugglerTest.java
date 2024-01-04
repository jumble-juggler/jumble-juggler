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

class DoubleJugglerTest {

  @Test
  void testGenerateRandomPositiveDouble() {
    double result = Assertions.assertDoesNotThrow(DoubleJuggler::generateRandomPositiveDouble);
    assertTrue(result >= 0);
  }

  @Test
  void testGenerateRandomNegativeDouble() {
    double result = assertDoesNotThrow(DoubleJuggler::generateRandomNegativeDouble);
    assertTrue(result < 0);
  }

  @Test
  void testGenerateRandomDoubleSmallerThan() {
    double random = DoubleJuggler.generateRandomDouble();

    double result = assertDoesNotThrow(() -> DoubleJuggler.generateRandomDoubleSmallerThan(random));
    assertTrue(result < random);
  }

  @Test
  void testGenerateRandomDoubleGreaterThan() {
    double random = DoubleJuggler.generateRandomDouble();

    double result = assertDoesNotThrow(() -> DoubleJuggler.generateRandomDoubleGreaterThan(random));
    assertTrue(result >= random);
  }

  @Test
  void testGenerateRandomPositiveDoubleGreaterThan() {
    double random = DoubleJuggler.generateRandomPositiveDouble();

    double result =
        assertDoesNotThrow(() -> DoubleJuggler.generateRandomPositiveDoubleGreaterThan(random));
    assertTrue(result >= 0 && result >= random);
  }

  @Test
  void testGenerateRandomPositiveDoubleGreaterThan_WhenMaxIsNegative_ThrowException() {
    double random = DoubleJuggler.generateRandomNegativeDouble();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> DoubleJuggler.generateRandomPositiveDoubleGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly positive.",
        exception.getMessage());
  }

  @Test
  void testGenerateRandomPositiveDoubleSmallerThan() {
    double random = DoubleJuggler.generateRandomPositiveDouble();

    double result =
        assertDoesNotThrow(() -> DoubleJuggler.generateRandomPositiveDoubleSmallerThan(random));
    assertTrue(result >= 0 && result < random);
  }

  @Test
  void testGenerateRandomPositiveDoubleSmallerThan_WhenMaxIsNegative_ThrowException() {
    double random = DoubleJuggler.generateRandomNegativeDouble();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> DoubleJuggler.generateRandomPositiveDoubleSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly positive.",
        exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeDoubleGreaterThan() {
    double random = DoubleJuggler.generateRandomNegativeDouble();
    double result =
        assertDoesNotThrow(() -> DoubleJuggler.generateRandomNegativeDoubleGreaterThan(random));
    assertTrue(result < 0 && result >= random);
  }

  @Test
  void testGenerateRandomNegativeDoubleGreaterThan_WhenMaxIsPositive_ThrowException() {
    double random = DoubleJuggler.generateRandomPositiveDouble();
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> DoubleJuggler.generateRandomNegativeDoubleGreaterThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly negative.",
        exception.getMessage());
  }

  @Test
  void testGenerateRandomNegativeDoubleSmallerThan() {
    double random = DoubleJuggler.generateRandomNegativeDouble();

    double result =
        assertDoesNotThrow(() -> DoubleJuggler.generateRandomNegativeDoubleSmallerThan(random));
    assertTrue(result < 0 && result < random);
  }

  @Test
  void testGenerateRandomNegativeDoubleSmallerThan_WhenMaxIsPositive_ThrowException() {
    double random = DoubleJuggler.generateRandomPositiveDouble();

    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> DoubleJuggler.generateRandomNegativeDoubleSmallerThan(random));
    assertEquals(
        "The value given is " + random + ", but it must be strictly negative.",
        exception.getMessage());
  }
}
