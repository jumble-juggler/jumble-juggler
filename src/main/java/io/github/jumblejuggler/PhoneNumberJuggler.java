/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import io.github.jumblejuggler.constants.Country;
import io.github.jumblejuggler.exceptions.JumbleJugglerException;
import java.util.logging.Logger;

/**
 * Utility class for randomizing and formatting phone numbers.
 *
 * <p>This class provides methods to generate random phone numbers, format them based on specified
 * criteria, and handle exceptions related to the randomization process.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Get a random phone number with a specified type and format
 * try {
 *     String randomPhoneNumber = PhoneNumberJuggler.getRandomPhoneNumberWithFormatAndType(
 *         PhoneNumberType.MOBILE, PhoneNumberFormat.INTERNATIONAL);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Get a random phone number for a specific country with a specified type and format
 * try {
 *     String randomPhoneNumberByCountry = PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
 *         "US", PhoneNumberType.FIXED_LINE, PhoneNumberFormat.NATIONAL);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 * }</pre>
 *
 * <p>The class uses the {@link CountryJuggler} class, {@link IntegerJuggler} class, and Google's
 * libphonenumber library for phone number generation and formatting. It throws {@link
 * JumbleJugglerException} for exceptional cases during the randomization process.
 *
 * @see CountryJuggler
 * @see IntegerJuggler
 * @see JumbleJugglerException
 * @see <a href="https://github.com/google/libphonenumber">libphonenumber</a>
 */
public class PhoneNumberJuggler {
  private static final Logger logger = Logger.getLogger(PhoneNumberJuggler.class.getName());
  private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();

  private PhoneNumberJuggler() {}

  /**
   * Generates a random phone number with a specified type and format.
   *
   * @param phoneNumberType The type of phone number (e.g., mobile, fixed line).
   * @param phoneNumberFormat The desired format of the phone number.
   * @return A randomly generated phone number formatted according to the specified criteria.
   */
  public static String getRandomPhoneNumberWithFormatAndType(
      PhoneNumberUtil.PhoneNumberType phoneNumberType,
      PhoneNumberUtil.PhoneNumberFormat phoneNumberFormat) {
    Phonenumber.PhoneNumber randomPhoneNumber;
    try {
      randomPhoneNumber = getRandomPhoneNumber(phoneNumberType);
    } catch (JumbleJugglerException e) {
      return getRandomPhoneNumberWithFormatAndType(phoneNumberType, phoneNumberFormat);
    }

    return formatRandomPhoneNumber(phoneNumberFormat, randomPhoneNumber);
  }

  /**
   * Generates a random phone number for a specific country with a specified type and format.
   *
   * @param countryCode The ISO2 code of the country.
   * @param phoneNumberType The type of phone number (e.g., mobile, fixed line).
   * @param phoneNumberFormat The desired format of the phone number.
   * @return A randomly generated phone number for the specified country and formatted accordingly.
   * @throws JumbleJugglerException if an error occurs during the randomization process.
   */
  public static String getRandomPhoneNumberWithFormatByCountryCodeAndType(
      String countryCode,
      PhoneNumberUtil.PhoneNumberType phoneNumberType,
      PhoneNumberUtil.PhoneNumberFormat phoneNumberFormat)
      throws JumbleJugglerException {
    Phonenumber.PhoneNumber randomPhoneNumber =
        getRandomPhoneNumberByCountryCode(
            CountryJuggler.getCountryByIso2Code(countryCode).name(), phoneNumberType);

    return formatRandomPhoneNumber(phoneNumberFormat, randomPhoneNumber);
  }

  private static Phonenumber.PhoneNumber getRandomPhoneNumber(
      PhoneNumberUtil.PhoneNumberType phoneNumberType) throws JumbleJugglerException {
    return randomizePhoneNumber(
        getExampleNumberForType(CountryJuggler.getRandomCountry().name(), phoneNumberType));
  }

  private static Phonenumber.PhoneNumber getRandomPhoneNumberByCountryCode(
      String countryCode, PhoneNumberUtil.PhoneNumberType phoneNumberType)
      throws JumbleJugglerException {
    return randomizePhoneNumber(getExampleNumberForType(countryCode, phoneNumberType));
  }

  private static Phonenumber.PhoneNumber getExampleNumberForType(
      String iso2, PhoneNumberUtil.PhoneNumberType phoneNumberType) throws JumbleJugglerException {
    Phonenumber.PhoneNumber phoneNumber =
        PHONE_NUMBER_UTIL.getExampleNumberForType(iso2, phoneNumberType);

    if (phoneNumber != null) {
      return phoneNumber;
    }

    String error =
        String.format(
            "The iso2 code provided belongs to %s but is not in the phone registry of"
                + " google's libphonenumber.",
            Country.valueOf(iso2));
    logger.warning(error);
    throw new JumbleJugglerException(error, PhoneNumberJuggler.class);
  }

  private static Phonenumber.PhoneNumber randomizePhoneNumber(Phonenumber.PhoneNumber phoneNumber) {
    String[] rcf3966Array =
        PHONE_NUMBER_UTIL.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split("-");
    String areaCode = rcf3966Array[1];
    String randomLocalNumber = generateRandomLocalNumber(rcf3966Array);
    phoneNumber.setNationalNumber(Long.parseLong(areaCode + randomLocalNumber));
    return phoneNumber;
  }

  private static String generateRandomLocalNumber(String[] rcf3966) {
    StringBuilder localNumberBuilder = new StringBuilder();

    for (int i = 2; i < rcf3966.length; i++) {
      localNumberBuilder.append(rcf3966[i]);
    }

    return localNumberBuilder.toString().isEmpty()
        ? ""
        : String.valueOf(
            LongJuggler.generateRandomPositiveLongWithLength(
                localNumberBuilder.toString().length()));
  }

  private static String formatRandomPhoneNumber(
      PhoneNumberUtil.PhoneNumberFormat phoneNumberFormat,
      Phonenumber.PhoneNumber randomPhoneNumber) {
    return PHONE_NUMBER_UTIL.format(randomPhoneNumber, phoneNumberFormat);
  }
}
