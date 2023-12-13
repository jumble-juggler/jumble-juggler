/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package org.jumble_juggler;

import java.util.concurrent.ThreadLocalRandom;
import org.jumble_juggler.exceptions.JumbleJugglerException;

/**
 * Utility class for generating random integers with various constraints.
 *
 * <p>This class provides methods for generating random integers within specified ranges, with
 * specific signs, and with a given length. It also handles constraints such as minimum and maximum
 * values, positivity, and negativity.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Get a random integer within a specified range
 * try {
 *     int randomIntInRange = IntegerJuggler.generateRandomIntBetween(10, 50);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Get a random positive integer greater than a specified minimum value
 * try {
 *     int randomPositiveInt = IntegerJuggler.generateRandomPositiveIntGreaterThan(5);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 * }</pre>
 *
 * <p>The class throws {@link JumbleJugglerException} for exceptional cases, such as invalid
 * constraints or when a negative value is provided where only positive values are allowed.
 *
 * @see JumbleJugglerException
 */
public class IntegerJuggler {
  private static final String BAD_NEGATIVE = "The value given is %s, but it must be positive.";
  private static final String BAD_POSITIVE = "The value given is %s, but it must be negative.";
  private static final String BAD_BOUND =
      "The minimum value given is %s, but it must be smaller than the maximum value given which is %s.";

  private IntegerJuggler() {}

  /**
   * Generates a random integer.
   *
   * @return A randomly generated integer.
   */
  public static int generateRandomInt() {
    return ThreadLocalRandom.current().nextInt();
  }

  /**
   * Generates a random positive integer.
   *
   * @return A randomly generated positive integer.
   */
  public static int generateRandomPositiveInt() {
    return ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
  }

  /**
   * Generates a random negative integer.
   *
   * @return A randomly generated negative integer.
   */
  public static int generateRandomNegativeInt() {
    return ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 0);
  }

  /**
   * Generates a random integer smaller than a specified maximum value.
   *
   * @param max The exclusive upper bound for the generated integer.
   * @return A randomly generated integer smaller than the specified maximum.
   */
  public static int generateRandomIntSmallerThan(int max) {
    return ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, max);
  }

  /**
   * Generates a random integer greater than a specified minimum value.
   *
   * @param min The inclusive lower bound for the generated integer.
   * @return A randomly generated integer greater than the specified minimum.
   */
  public static int generateRandomIntGreaterThan(int min) {
    return ThreadLocalRandom.current().nextInt(min, Integer.MAX_VALUE);
  }

  /**
   * Generates a random positive integer smaller than a specified maximum value.
   *
   * @param max The exclusive upper bound for the generated positive integer.
   * @return A randomly generated positive integer smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is negative.
   */
  public static int generateRandomPositiveIntSmallerThan(int max) throws JumbleJugglerException {
    if (max < 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, max)), IntegerJuggler.class);
    }
    return ThreadLocalRandom.current().nextInt(max);
  }

  /**
   * Generates a random positive integer greater than a specified minimum value.
   *
   * @param min The inclusive lower bound for the generated positive integer.
   * @return A randomly generated positive integer greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is negative.
   */
  public static int generateRandomPositiveIntGreaterThan(int min) throws JumbleJugglerException {
    if (min < 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, min)), IntegerJuggler.class);
    }
    return generateRandomIntGreaterThan(min);
  }

  /**
   * Generates a random negative integer smaller than a specified maximum value.
   *
   * @param max The exclusive upper bound for the generated negative integer.
   * @return A randomly generated negative integer smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is positive.
   */
  public static int generateRandomNegativeIntSmallerThan(int max) throws JumbleJugglerException {
    if (max > 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, max)), IntegerJuggler.class);
    }
    return generateRandomIntSmallerThan(max);
  }

  /**
   * Generates a random negative integer greater than a specified minimum value.
   *
   * @param min The inclusive lower bound for the generated negative integer.
   * @return A randomly generated negative integer greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is positive.
   */
  public static int generateRandomNegativeIntGreaterThan(int min) throws JumbleJugglerException {
    if (min > 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, min)), IntegerJuggler.class);
    }
    return ThreadLocalRandom.current().nextInt(min, 0);
  }

  /**
   * Generates a random integer between a specified minimum and maximum value.
   *
   * @param min The inclusive lower bound for the generated integer.
   * @param max The exclusive upper bound for the generated integer.
   * @return A randomly generated integer within the specified range.
   * @throws JumbleJugglerException if the minimum value is greater than the maximum value.
   */
  public static int generateRandomIntBetween(int min, int max) throws JumbleJugglerException {
    if (min > max) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_BOUND, min, max)), IntegerJuggler.class);
    }
    return ThreadLocalRandom.current().nextInt(min, max);
  }

  /**
   * Generates a random positive integer with a specified length.
   *
   * @param length The length of the generated positive integer.
   * @return A randomly generated positive integer with the specified length.
   */
  public static int generateRandomPositiveIntWithLength(int length) {
    return ThreadLocalRandom.current().nextInt((9 * (int) Math.pow(10, length - 1)) - 1)
        + (int) Math.pow(10, length - 1);
  }
}
