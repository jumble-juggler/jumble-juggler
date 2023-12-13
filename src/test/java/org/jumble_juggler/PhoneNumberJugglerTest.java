/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package org.jumble_juggler;

import static org.junit.jupiter.api.Assertions.*;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.jumble_juggler.constants.Country;
import org.jumble_juggler.exceptions.JumbleJugglerException;
import org.junit.jupiter.api.Test;

class PhoneNumberJugglerTest {

  @Test
  void getRandomPhoneNumberWithFormatAndType() {
    assertAll(
        () ->
            assertDoesNotThrow(
                () -> {
                  String result =
                      PhoneNumberJuggler.getRandomPhoneNumberWithFormatAndType(
                          PhoneNumberUtil.PhoneNumberType.MOBILE,
                          PhoneNumberUtil.PhoneNumberFormat.E164);
                  assertTrue(result.startsWith("+"));
                }),
        () ->
            assertDoesNotThrow(
                () -> {
                  String result =
                      PhoneNumberJuggler.getRandomPhoneNumberWithFormatAndType(
                          PhoneNumberUtil.PhoneNumberType.MOBILE,
                          PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
                  assertFalse(result.startsWith("+"));
                }),
        () ->
            assertDoesNotThrow(
                () -> {
                  String result =
                      PhoneNumberJuggler.getRandomPhoneNumberWithFormatAndType(
                          PhoneNumberUtil.PhoneNumberType.MOBILE,
                          PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                  assertTrue(result.startsWith("+"));
                }),
        () ->
            assertDoesNotThrow(
                () -> {
                  String result =
                      PhoneNumberJuggler.getRandomPhoneNumberWithFormatAndType(
                          PhoneNumberUtil.PhoneNumberType.MOBILE,
                          PhoneNumberUtil.PhoneNumberFormat.RFC3966);
                  assertTrue(result.startsWith("tel:+"));
                }));
  }

  @Test
  void getRandomPhoneNumberWithFormatByCountryCodeAndType() {
    for (Country country : Country.values()) {
      if (country.isInGoogleLibPhoneNumber()) {
        assertAll(
            () ->
                assertDoesNotThrow(
                    () -> {
                      String result =
                          PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                              country.name(),
                              PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                              PhoneNumberUtil.PhoneNumberFormat.E164);
                      assertTrue(result.startsWith("+"));
                    }),
            () ->
                assertDoesNotThrow(
                    () -> {
                      String result =
                          PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                              country.name(),
                              PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                              PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
                      assertFalse(result.startsWith("+"));
                    }),
            () ->
                assertDoesNotThrow(
                    () -> {
                      String result =
                          PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                              country.name(),
                              PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                              PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                      assertTrue(result.startsWith("+"));
                    }),
            () ->
                assertDoesNotThrow(
                    () -> {
                      String result =
                          PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                              country.name(),
                              PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                              PhoneNumberUtil.PhoneNumberFormat.RFC3966);
                      assertTrue(result.startsWith("tel:+"));
                    }));
      } else {
        assertAll(
            () -> {
              JumbleJugglerException exception =
                  assertThrows(
                      JumbleJugglerException.class,
                      () -> {
                        String result =
                            PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                                country.name(),
                                PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                                PhoneNumberUtil.PhoneNumberFormat.E164);
                        assertTrue(result.startsWith("tel:+"));
                      });
              assertEquals(
                  String.format(
                      "The iso2 code provided belongs to %s but is not in the"
                          + " phone registry of google's libphonenumber.",
                      country.name()),
                  exception.getMessage());
            },
            () -> {
              JumbleJugglerException exception =
                  assertThrows(
                      JumbleJugglerException.class,
                      () -> {
                        String result =
                            PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                                country.name(),
                                PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                                PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
                        assertTrue(result.startsWith("tel:+"));
                      });
              assertEquals(
                  String.format(
                      "The iso2 code provided belongs to %s but is not in the"
                          + " phone registry of google's libphonenumber.",
                      country.name()),
                  exception.getMessage());
            },
            () -> {
              JumbleJugglerException exception =
                  assertThrows(
                      JumbleJugglerException.class,
                      () -> {
                        String result =
                            PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                                country.name(),
                                PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                                PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                        assertTrue(result.startsWith("tel:+"));
                      });
              assertEquals(
                  String.format(
                      "The iso2 code provided belongs to %s but is not in the"
                          + " phone registry of google's libphonenumber.",
                      country.name()),
                  exception.getMessage());
            },
            () -> {
              JumbleJugglerException exception =
                  assertThrows(
                      JumbleJugglerException.class,
                      () -> {
                        String result =
                            PhoneNumberJuggler.getRandomPhoneNumberWithFormatByCountryCodeAndType(
                                country.name(),
                                PhoneNumberUtil.PhoneNumberType.FIXED_LINE,
                                PhoneNumberUtil.PhoneNumberFormat.RFC3966);
                        assertTrue(result.startsWith("tel:+"));
                      });
              assertEquals(
                  String.format(
                      "The iso2 code provided belongs to %s but is not in the"
                          + " phone registry of google's libphonenumber.",
                      country.name()),
                  exception.getMessage());
            });
      }
    }
  }
}
