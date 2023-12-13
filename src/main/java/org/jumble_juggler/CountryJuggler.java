/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package org.jumble_juggler;

import org.jumble_juggler.constants.Country;
import org.jumble_juggler.exceptions.JumbleJugglerException;

/**
 * Utility class for randomizing and retrieving information about countries.
 *
 * <p>This class provides methods to generate a random country and retrieve country information
 * based on ISO2 or ISO3 codes. It relies on the {@link Country} enum for country data.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Get a random country
 * Country randomCountry = CountryJuggler.getRandomCountry();
 *
 * // Get a country by ISO2 code
 * try {
 *     Country countryByIso2 = CountryJuggler.getCountryByIso2Code("US");
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Get a country by ISO3 code
 * try {
 *     Country countryByIso3 = CountryJuggler.getCountryByIso3Code("USA");
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 * }</pre>
 *
 * <p>The class uses the {@link IntegerJuggler} class and relies on the {@link Country} enum,
 * throwing {@link JumbleJugglerException} for invalid ISO codes or if the requested country does
 * not exist.
 *
 * @see Country
 * @see IntegerJuggler
 * @see JumbleJugglerException
 */
public class CountryJuggler {
  private static final String ISO2_REGEX_ERROR =
      "The provided iso2 code is invalid. The iso2 code is a two-letter string only. Example: \"FR\"";
  private static final String ISO3_REGEX_ERROR =
      "The provided iso3 code is invalid. The iso3 code is a three-letter string only. Example: \"USA\"";
  private static final String COUNTRY_DOES_NOT_EXIST =
      "Based on the provided code, the country does not exist. Make sure you input the correct code.";

  private CountryJuggler() {}

  /**
   * Generates and returns a random country.
   *
   * @return A random {@link Country} enum constant.
   * @throws JumbleJugglerException if an error occurs during the randomization process.
   */
  public static Country getRandomCountry() throws JumbleJugglerException {
    return Country.COUNTRIES.get(
        IntegerJuggler.generateRandomPositiveIntSmallerThan(Country.COUNTRIES.size()));
  }

  /**
   * Retrieves a country based on its ISO2 code.
   *
   * @param iso2Code The ISO2 code of the country (two letters).
   * @return The {@link Country} object corresponding to the provided ISO2 code.
   * @throws JumbleJugglerException if the provided ISO2 code is invalid or if the country does not
   *     exist.
   */
  public static Country getCountryByIso2Code(String iso2Code) throws JumbleJugglerException {
    if (!iso2Code.matches("^[a-zA-Z]{2}$")) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(ISO2_REGEX_ERROR), CountryJuggler.class);
    }

    Country country = Country.ISO2_COUNTRY_MAP.get(iso2Code.toUpperCase());
    if (country == null) {
      throw new JumbleJugglerException(COUNTRY_DOES_NOT_EXIST, CountryJuggler.class);
    }
    return country;
  }

  /**
   * Retrieves a country based on its ISO3 code.
   *
   * @param iso3Code The ISO3 code of the country (three letters).
   * @return The {@link Country} object corresponding to the provided ISO3 code.
   * @throws JumbleJugglerException if the provided ISO3 code is invalid or if the country does not
   *     exist.
   */
  public static Country getCountryByIso3Code(String iso3Code) throws JumbleJugglerException {
    if (!iso3Code.matches("^[a-zA-Z]{3}$")) {
      throw new JumbleJugglerException(
          new IllegalArgumentException(ISO3_REGEX_ERROR), CountryJuggler.class);
    }

    Country country = Country.ISO3_COUNTRY_MAP.get(iso3Code.toUpperCase());
    if (country == null) {
      throw new JumbleJugglerException(COUNTRY_DOES_NOT_EXIST, CountryJuggler.class);
    }
    return country;
  }
}
