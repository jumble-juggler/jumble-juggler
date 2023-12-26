/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler;

import io.github.jumblejuggler.exceptions.JumbleJugglerException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for generating random longs with various constraints.
 *
 * <p>This class provides methods for generating random longs within specified ranges, with specific
 * signs, and with a given length. It also handles constraints such as minimum and maximum values,
 * positivity, and negativity.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Get a random long within a specified range
 * try {
 *     long randomLongInRange = LongJuggler.generateRandomLongBetween(10, 50);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Get a random positive long greater than a specified minimum value
 * try {
 *     long randomPositiveLong = LongJuggler.generateRandomPositiveLongGreaterThan(5);
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
public class LongJuggler {
  private static final String BAD_POSITIVE = "The value given is %s, but it must be negative.";
  private static final String BAD_NEGATIVE = "The value given is %s, but it must be positive.";
  private static final String BAD_BOUND =
      "The minimum value given is %s, but it must be smaller than the maximum value given"
          + " which is %s.";

  private LongJuggler() {}

  /**
   * Generates a random long.
   *
   * @return A randomly generated long.
   */
  public static long generateRandomLong() {
    return ThreadLocalRandom.current().nextLong();
  }

  /**
   * Generates a random positive long.
   *
   * @return A randomly generated positive long.
   */
  public static long generateRandomPositiveLong() {
    return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
  }

  /**
   * Generates a random negative long.
   *
   * @return A randomly generated negative long.
   */
  public static long generateRandomNegativeLong() {
    return ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, 0L);
  }

  /**
   * Generates a random long smaller than a specified maximum value.
   *
   * @param max The exclusive upper bound for the generated long.
   * @return A randomly generated long smaller than the specified maximum.
   */
  public static long generateRandomLongSmallerThan(long max) {
    return ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, max);
  }

  /**
   * Generates a random long greater than a specified minimum value.
   *
   * @param min The inclusive lower bound for the generated long.
   * @return A randomly generated long greater than the specified minimum.
   */
  public static long generateRandomLongGreaterThan(long min) {
    return ThreadLocalRandom.current().nextLong(min, Long.MAX_VALUE);
  }

  /**
   * Generates a random positive long smaller than a specified maximum value.
   *
   * @param max The exclusive upper bound for the generated positive long.
   * @return A randomly generated positive long smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is negative.
   */
  public static long generateRandomPositiveLongSmallerThan(long max) throws JumbleJugglerException {
    if (max < 0L) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, max)), LongJuggler.class);
    }
    return ThreadLocalRandom.current().nextLong(max);
  }

  /**
   * Generates a random positive long greater than a specified minimum value.
   *
   * @param min The inclusive lower bound for the generated positive long.
   * @return A randomly generated positive long greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is negative.
   */
  public static long generateRandomPositiveLongGreaterThan(long min) throws JumbleJugglerException {
    if (min < 0L) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, min)), LongJuggler.class);
    }
    return generateRandomLongGreaterThan(min);
  }

  /**
   * Generates a random negative long smaller than a specified maximum value.
   *
   * @param max The exclusive upper bound for the generated negative long.
   * @return A randomly generated negative long smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is positive.
   */
  public static long generateRandomNegativeLongSmallerThan(long max) throws JumbleJugglerException {
    if (max > 0L) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, max)), LongJuggler.class);
    }
    return generateRandomLongSmallerThan(max);
  }

  /**
   * Generates a random negative long greater than a specified minimum value.
   *
   * @param min The inclusive lower bound for the generated negative long.
   * @return A randomly generated negative long greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is positive.
   */
  public static long generateRandomNegativeLongGreaterThan(long min) throws JumbleJugglerException {
    if (min > 0L) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, min)), LongJuggler.class);
    }
    return ThreadLocalRandom.current().nextLong(min, 0L);
  }

  /**
   * Generates a random long between a specified minimum and maximum value.
   *
   * @param min The inclusive lower bound for the generated long.
   * @param max The exclusive upper bound for the generated long.
   * @return A randomly generated long within the specified range.
   * @throws JumbleJugglerException if the minimum value is greater than the maximum value.
   */
  public static long generateRandomLongBetween(long min, long max) throws JumbleJugglerException {
    if (min > max) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_BOUND, min, max)), LongJuggler.class);
    }
    return ThreadLocalRandom.current().nextLong(min, max);
  }

  /**
   * Generates a random positive long with a specified length.
   *
   * @param length The length of the generated positive long.
   * @return A randomly generated positive long with the specified length.
   */
  public static long generateRandomPositiveLongWithLength(long length) {
    return ThreadLocalRandom.current().nextLong((9L * (long) Math.pow(10L, length - 1d)) - 1L)
        + (long) Math.pow(10L, length - 1d);
  }
}
