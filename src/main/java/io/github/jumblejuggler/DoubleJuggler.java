/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler;

import io.github.jumblejuggler.exceptions.JumbleJugglerException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class for generating random doubles between 0.0F and 1.0F with various constraints.
 *
 * <p>This class provides methods for generating random doubles within specified ranges, with
 * specific signs, and with a given length. It also handles constraints such as minimum and maximum
 * values, positivity, and negativity.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Get a random double within a specified range
 * try {
 *     double randomDoubleInRange = DoubleJuggler.generateRandomDoubleBetween(10, 50);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Get a random positive double greater than a specified minimum value
 * try {
 *     double randomPositiveDouble = DoubleJuggler.generateRandomPositiveDoubleGreaterThan(5);
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
public class DoubleJuggler {
  private static final int[] NEGATIVE_POSITIVE_ONES = {-1, 1};
  private static final String BAD_NEGATIVE =
      "The value given is %s, but it must be strictly positive.";
  private static final String BAD_POSITIVE =
      "The value given is %s, but it must be strictly negative.";

  private DoubleJuggler() {}

  /**
   * Generates a random double between {@link Double#MAX_VALUE} * {@code -1} (excluded) and {@link
   * Double#MAX_VALUE} (excluded).
   *
   * @return A randomly generated double.
   */
  public static double generateRandomDouble() {
    return ThreadLocalRandom.current().nextDouble(Double.MAX_VALUE)
        * NEGATIVE_POSITIVE_ONES[
            IntegerJuggler.generateRandomPositiveIntSmallerThan(NEGATIVE_POSITIVE_ONES.length)];
  }

  /**
   * Generates a random positive double grater than {@link Double#MIN_VALUE} (included) smaller than
   * {@link Double#MAX_VALUE} (excluded).
   *
   * @return A randomly generated positive double.
   */
  public static double generateRandomPositiveDouble() {
    return ThreadLocalRandom.current().nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);
  }

  /**
   * Generates a random negative double.
   *
   * @return A randomly generated negative double.
   */
  public static double generateRandomNegativeDouble() {
    return generateRandomPositiveDouble() * NEGATIVE_POSITIVE_ONES[0];
  }

  /**
   * Generates a random double smaller than a specified maximum value (excluded).
   *
   * @param max The exclusive upper bound for the generated double.
   * @return A randomly generated double smaller than the specified maximum.
   */
  public static double generateRandomDoubleSmallerThan(double max) {
    if (max == 0) {
      return generateRandomNegativeDouble();
    } else {
      if (max < 0)
        return ThreadLocalRandom.current().nextDouble(-max, Double.MAX_VALUE)
            * NEGATIVE_POSITIVE_ONES[0];
      return ThreadLocalRandom.current().nextDouble(max)
          * NEGATIVE_POSITIVE_ONES[
              IntegerJuggler.generateRandomPositiveIntSmallerThan(NEGATIVE_POSITIVE_ONES.length)];
    }
  }

  /**
   * Generates a random double greater than a specified minimum value (included).
   *
   * @param min The inclusive lower bound for the generated double.
   * @return A randomly generated double greater than the specified minimum.
   */
  public static double generateRandomDoubleGreaterThan(double min) {
    if (min == 0) {
      return generateRandomPositiveDouble();
    } else {
      if (min < 0) return ThreadLocalRandom.current().nextDouble(-min, Double.MAX_VALUE) + min;
      return ThreadLocalRandom.current().nextDouble(min, Double.MAX_VALUE);
    }
  }

  /**
   * Generates a random positive double smaller than a specified maximum value (excluded).
   *
   * @param max The exclusive upper bound for the generated positive double.
   * @return A randomly generated positive double smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is negative.
   */
  public static double generateRandomPositiveDoubleSmallerThan(double max)
      throws JumbleJugglerException {
    if (max <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, max)), DoubleJuggler.class);
    }
    return ThreadLocalRandom.current().nextDouble(max);
  }

  /**
   * Generates a random positive double greater than a specified minimum value (included).
   *
   * @param min The inclusive lower bound for the generated positive double.
   * @return A randomly generated positive double greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is negative.
   */
  public static double generateRandomPositiveDoubleGreaterThan(double min)
      throws JumbleJugglerException {
    if (min <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, min)), DoubleJuggler.class);
    }
    return generateRandomDoubleGreaterThan(min);
  }

  /**
   * Generates a random negative double smaller than a specified maximum value (excluded).
   *
   * @param max The exclusive upper bound for the generated negative double.
   * @return A randomly generated negative double smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is positive.
   */
  public static double generateRandomNegativeDoubleSmallerThan(double max)
      throws JumbleJugglerException {
    if (max >= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, max)), DoubleJuggler.class);
    }
    return generateRandomDoubleSmallerThan(max);
  }

  /**
   * Generates a random negative double greater than a specified minimum value (included).
   *
   * @param min The inclusive lower bound for the generated negative double.
   * @return A randomly generated negative double greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is positive.
   */
  public static double generateRandomNegativeDoubleGreaterThan(double min)
      throws JumbleJugglerException {
    if (min > 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, min)), DoubleJuggler.class);
    }
    return ThreadLocalRandom.current().nextDouble(0.0F, -min) * NEGATIVE_POSITIVE_ONES[0];
  }
}
