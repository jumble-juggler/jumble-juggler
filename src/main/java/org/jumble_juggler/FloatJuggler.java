/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package org.jumble_juggler;

import java.util.concurrent.ThreadLocalRandom;
import org.jumble_juggler.exceptions.JumbleJugglerException;

/**
 * Utility class for generating random floats between 0.0F and 1.0F with various constraints.
 *
 * <p>This class provides methods for generating random floats within specified ranges, with
 * specific signs, and with a given length. It also handles constraints such as minimum and maximum
 * values, positivity, and negativity.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Get a random float within a specified range
 * try {
 *     float randomFloatInRange = FloatJuggler.generateRandomFloatBetween(10, 50);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Get a random positive float greater than a specified minimum value
 * try {
 *     float randomPositiveFloat = FloatJuggler.generateRandomPositiveFloatGreaterThan(5);
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
public class FloatJuggler {
  private static final int[] NEGATIVE_POSITIVE_ONES = {-1, 1};
  private static final String BAD_NEGATIVE = "The value given is %s, but it must be positive.";
  private static final String BAD_POSITIVE = "The value given is %s, but it must be negative.";
  private static final String BAD_BOUND =
      "The minimum value given is %s, but it must be smaller than the maximum value given which is %s.";

  private FloatJuggler() {}

  /**
   * Generates a random float between {@link Float#MAX_VALUE} * {@code -1} (excluded) and {@link
   * Float#MAX_VALUE} (excluded).
   *
   * @return A randomly generated float.
   */
  public static float generateRandomFloat() {
    return ThreadLocalRandom.current().nextFloat(Float.MAX_VALUE)
        * NEGATIVE_POSITIVE_ONES[
            IntegerJuggler.generateRandomPositiveIntSmallerThan(NEGATIVE_POSITIVE_ONES.length)];
  }

  /**
   * Generates a random positive float grater than {@link Float#MIN_VALUE} (included) smaller than
   * {@link Float#MAX_VALUE} (excluded).
   *
   * @return A randomly generated positive float.
   */
  public static float generateRandomPositiveFloat() {
    return ThreadLocalRandom.current().nextFloat(Float.MIN_VALUE, Float.MAX_VALUE);
  }

  /**
   * Generates a random negative float.
   *
   * @return A randomly generated negative float.
   */
  public static float generateRandomNegativeFloat() {
    return generateRandomPositiveFloat() * NEGATIVE_POSITIVE_ONES[0];
  }

  /**
   * Generates a random float smaller than a specified maximum value (excluded).
   *
   * @param max The exclusive upper bound for the generated float.
   * @return A randomly generated float smaller than the specified maximum.
   */
  public static float generateRandomFloatSmallerThan(float max) {

    return max < 0
        ? ThreadLocalRandom.current().nextFloat(-max, Float.MAX_VALUE) * NEGATIVE_POSITIVE_ONES[0]
        : ThreadLocalRandom.current().nextFloat(max)
            * NEGATIVE_POSITIVE_ONES[
                IntegerJuggler.generateRandomPositiveIntSmallerThan(NEGATIVE_POSITIVE_ONES.length)];
  }

  /**
   * Generates a random float greater than a specified minimum value (included).
   *
   * @param min The inclusive lower bound for the generated float.
   * @return A randomly generated float greater than the specified minimum.
   */
  public static float generateRandomFloatGreaterThan(float min) {
    return min < 0
        ? ThreadLocalRandom.current().nextFloat(-min, Float.MAX_VALUE) + min
        : ThreadLocalRandom.current().nextFloat(min, Float.MAX_VALUE);
  }

  /**
   * Generates a random positive float smaller than a specified maximum value (excluded).
   *
   * @param max The exclusive upper bound for the generated positive float.
   * @return A randomly generated positive float smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is negative.
   */
  public static float generateRandomPositiveFloatSmallerThan(float max)
      throws JumbleJugglerException {
    if (max < 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, max)), FloatJuggler.class);
    }
    return ThreadLocalRandom.current().nextFloat(max);
  }

  /**
   * Generates a random positive float greater than a specified minimum value (included).
   *
   * @param min The inclusive lower bound for the generated positive float.
   * @return A randomly generated positive float greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is negative.
   */
  public static float generateRandomPositiveFloatGreaterThan(float min)
      throws JumbleJugglerException {
    if (min < 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_NEGATIVE, min)), FloatJuggler.class);
    }
    return generateRandomFloatGreaterThan(min);
  }

  /**
   * Generates a random negative float smaller than a specified maximum value (excluded).
   *
   * @param max The exclusive upper bound for the generated negative float.
   * @return A randomly generated negative float smaller than the specified maximum.
   * @throws JumbleJugglerException if the provided maximum value is positive.
   */
  public static float generateRandomNegativeFloatSmallerThan(float max)
      throws JumbleJugglerException {
    if (max > 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, max)), FloatJuggler.class);
    }
    return generateRandomFloatSmallerThan(max);
  }

  /**
   * Generates a random negative float greater than a specified minimum value (included).
   *
   * @param min The inclusive lower bound for the generated negative float.
   * @return A randomly generated negative float greater than the specified minimum.
   * @throws JumbleJugglerException if the provided minimum value is positive.
   */
  public static float generateRandomNegativeFloatGreaterThan(float min)
      throws JumbleJugglerException {
    if (min > 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_POSITIVE, min)), FloatJuggler.class);
    }
    return ThreadLocalRandom.current().nextFloat(0.0F, -min) * NEGATIVE_POSITIVE_ONES[0];
  }

  /**
   * Generates a random float between a specified minimum (included) and maximum value (included).
   *
   * @param min The inclusive lower bound for the generated float.
   * @param max The exclusive upper bound for the generated float.
   * @return A randomly generated float within the specified range.
   * @throws JumbleJugglerException if the minimum value is greater than the maximum value.
   */
  public static float generateRandomFloatBetween(float min, float max)
      throws JumbleJugglerException {
    if (min > max) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(String.format(BAD_BOUND, min, max)), FloatJuggler.class);
    }
    return min > 0 && max > 0
        ? ThreadLocalRandom.current().nextFloat(min, max)
        : min < 0 && max > 0
            ? -min < max
                ? ThreadLocalRandom.current().nextFloat(-min, max) + min
                : ThreadLocalRandom.current().nextFloat(max, -min) + min
            : -min < -max
                ? ThreadLocalRandom.current().nextFloat(-min, -max) * NEGATIVE_POSITIVE_ONES[0]
                : ThreadLocalRandom.current().nextFloat(-max - Float.MIN_VALUE, -min)
                    * NEGATIVE_POSITIVE_ONES[0];
  }
}
