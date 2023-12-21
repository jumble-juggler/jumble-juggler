/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.hajjoujti.jumble_juggler;

import static org.junit.jupiter.api.Assertions.*;

import io.github.hajjoujti.jumble_juggler.constants.Country;
import io.github.hajjoujti.jumble_juggler.exceptions.JumbleJugglerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountryJugglerTest {

  @Test
  void getCountryByIso2Code() {
    Country country =
        Assertions.assertDoesNotThrow(() -> CountryJuggler.getCountryByIso2Code("BE"));
    assertEquals(Country.BE, country);
  }

  @Test
  void getCountryByIso2Code_WhenIso2IsInvalid_ThrowException() {
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class, () -> CountryJuggler.getCountryByIso2Code("BEE"));
    assertEquals(
        "The provided iso2 code is invalid. The iso2 code is a two-letter string only. Example: \"FR\"",
        exception.getMessage());
  }

  @Test
  void getCountryByIso2Code_WhenIso2DoesNotBelongToACountry_ThrowException() {
    JumbleJugglerException exception =
        assertThrows(JumbleJugglerException.class, () -> CountryJuggler.getCountryByIso2Code("ZZ"));
    assertEquals(
        "Based on the provided code, the country does not exist. Make sure you input the correct code.",
        exception.getMessage());
  }

  @Test
  void getCountryByIso3Code() {
    Country country =
        Assertions.assertDoesNotThrow(() -> CountryJuggler.getCountryByIso3Code("LBN"));
    assertEquals(Country.LB, country);
    assertEquals("Lebanon", country.getCountryName());
    assertEquals("🇱🇧", country.getUnicode());
    assertEquals("LBP", country.getCurrency());
    assertEquals("Beirut", country.getCapital());
    assertEquals("AS", country.getContinent());
    assertTrue(country.isInGoogleLibPhoneNumber());
  }

  @Test
  void getCountryByIso3Code_WhenIso3IsInvalid_ThrowException() {
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class, () -> CountryJuggler.getCountryByIso3Code("ZZRF"));
    assertEquals(
        "The provided iso3 code is invalid. The iso3 code is a three-letter string only. Example: \"USA\"",
        exception.getMessage());
  }

  @Test
  void getCountryByIso3Code_WhenIso3DoesNotBelongToACountry_ThrowException() {
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class, () -> CountryJuggler.getCountryByIso3Code("ZZZ"));
    assertEquals(
        "Based on the provided code, the country does not exist. Make sure you input the correct code.",
        exception.getMessage());
  }
}
