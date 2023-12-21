/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.hajjoujti.jumble_juggler;

import static org.junit.jupiter.api.Assertions.*;

import io.github.hajjoujti.jumble_juggler.exceptions.JumbleJugglerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordJugglerTest {

  @Test
  void getRandomDictionaryWord() {
    String word = assertDoesNotThrow(WordJuggler::getRandomDictionaryWord);
    assertFalse(word.isEmpty());
  }

  @Test
  void getRandomDictionaryWordStartingWithCharacter() {
    String word =
        Assertions.assertDoesNotThrow(
            () -> WordJuggler.getRandomDictionaryWordStartingWithCharacter('a'));
    assertFalse(word.isEmpty());
    assertTrue(word.startsWith("A"));
  }

  @Test
  void
      getRandomDictionaryWordStartingWithCharacter_WhenCharacterIsNotInEnglishAlphabet_ThrowsException() {
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> WordJuggler.getRandomDictionaryWordStartingWithCharacter('ç'));
    assertEquals(
        "The character \"ç\" given is not in the English alphabet", exception.getMessage());
  }

  @Test
  void getRandomDictionaryWordStartingWithString() {
    String word =
        Assertions.assertDoesNotThrow(
            () -> WordJuggler.getRandomDictionaryWordStartingWithString("Na"));
    assertFalse(word.isEmpty());
    assertTrue(word.startsWith("NA"));
  }

  @Test
  void
      getRandomDictionaryWordStartingWithString_WhenNoWordsStartingWithStringFound_ThrowsException() {
    JumbleJugglerException exception =
        assertThrows(
            JumbleJugglerException.class,
            () -> WordJuggler.getRandomDictionaryWordStartingWithString("Na3"));
    assertEquals("No Words start with \"Na3\"", exception.getMessage());
  }
}
