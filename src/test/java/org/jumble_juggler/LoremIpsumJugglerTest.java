/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package org.jumble_juggler;

import static org.junit.jupiter.api.Assertions.*;

import org.jumble_juggler.exceptions.JumbleJugglerException;
import org.junit.jupiter.api.Test;

class LoremIpsumJugglerTest {
  private static final int MIN_WORDS = 10;
  private static final int MAX_WORDS = 20;
  private static final int MIN_SENTENCES = 3;
  private static final int MAX_SENTENCES = 5;

  @Test
  void generateRandomSentence() {
    String result = assertDoesNotThrow(LoremIpsumJuggler::generateRandomSentence);
    assertTrue(result.split(" ").length >= MIN_WORDS);
    assertTrue(result.split(" ").length <= MAX_WORDS);
  }

  @Test
  void generateRandomSentenceOfWords() {
    String result = assertDoesNotThrow(() -> LoremIpsumJuggler.generateRandomSentenceOfWords(15));
    assertEquals(15, result.split(" ").length);
  }

  @Test
  void generateRandomSentenceOfWordsBetween() {
    int minWords = 20;
    int maxWords = 40;
    String result =
        assertDoesNotThrow(
            () -> LoremIpsumJuggler.generateRandomSentenceOfWordsBetween(minWords, maxWords));
    assertTrue(result.split(" ").length >= minWords);
    assertTrue(result.split(" ").length <= maxWords);
  }

  @Test
  void generateRandomParagraph() {
    String result = assertDoesNotThrow(LoremIpsumJuggler::generateRandomParagraph);
    assertTrue(result.split(" ").length >= MIN_SENTENCES * MIN_WORDS);
    assertTrue(result.split(" ").length <= MAX_SENTENCES * MAX_WORDS);
  }

  @Test
  void generateRandomParagraphWithSentences() {
    int sentencesNumber = 20;
    String result =
        assertDoesNotThrow(
            () -> LoremIpsumJuggler.generateRandomParagraphWithSentences(sentencesNumber));
    assertTrue(result.split(" ").length >= sentencesNumber * MIN_WORDS);
    assertTrue(result.split(" ").length <= sentencesNumber * MAX_WORDS);
  }

  @Test
  void generateRandomParagraphWithSentencesBetween() {
    int minSentences = 20;
    int maxSentences = 25;
    String result =
        assertDoesNotThrow(
            () ->
                LoremIpsumJuggler.generateRandomParagraphWithSentencesBetween(
                    minSentences, maxSentences));
    assertTrue(result.split(" ").length >= minSentences * MIN_WORDS);
    assertTrue(result.split(" ").length <= maxSentences * MAX_WORDS);
  }

  @Test
  void generateRandomParagraphWithSentencesOfWordsBetween() {
    int minWords = 15;
    int maxWords = 25;
    int sentencesNumber = 10;
    String result =
        assertDoesNotThrow(
            () ->
                LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWordsBetween(
                    sentencesNumber, minWords, maxWords));
    assertTrue(result.split(" ").length >= sentencesNumber * minWords);
    assertTrue(result.split(" ").length <= sentencesNumber * maxWords);
  }

  @Test
  void generateRandomParagraphWithSentencesBetweenOfWordsBetween() {
    int minWords = 32;
    int maxWords = 65;
    int minSentences = 12;
    int maxSentences = 64;
    String result =
        assertDoesNotThrow(
            () ->
                LoremIpsumJuggler.generateRandomParagraphWithSentencesBetweenMadeOfWordsBetween(
                    minSentences, maxSentences, minWords, maxWords));
    assertTrue(result.split(" ").length >= minSentences * minWords);
    assertTrue(result.split(" ").length <= maxSentences * maxWords);
  }

  @Test
  void generateRandomParagraphWithSentencesOfWords() {
    String result =
        assertDoesNotThrow(
            () -> LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWords(7, 16));
    assertEquals(7 * 16, result.split(" ").length);
  }

  @Test
  void throwExceptions() {
    assertAll(
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomSentenceOfWords(0));
          assertEquals("The number of words provided needs to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomSentenceOfWordsBetween(-5, 15));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomSentenceOfWordsBetween(5, -15));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomParagraphWithSentences(-1));
          assertEquals(
              "The number of sentences provided needs to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomParagraphWithSentencesBetween(-1, 4));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomParagraphWithSentencesBetween(1, -4));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () ->
                      LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWordsBetween(
                          -9, 2, 10));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () ->
                      LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWordsBetween(
                          9, -2, 10));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () ->
                      LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWordsBetween(
                          9, 2, -10));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () ->
                      LoremIpsumJuggler
                          .generateRandomParagraphWithSentencesBetweenMadeOfWordsBetween(
                              -13, 15, 6, 21));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () ->
                      LoremIpsumJuggler
                          .generateRandomParagraphWithSentencesBetweenMadeOfWordsBetween(
                              13, -15, 6, 21));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () ->
                      LoremIpsumJuggler
                          .generateRandomParagraphWithSentencesBetweenMadeOfWordsBetween(
                              13, 15, -6, 21));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () ->
                      LoremIpsumJuggler
                          .generateRandomParagraphWithSentencesBetweenMadeOfWordsBetween(
                              13, 15, 6, -21));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWords(-16, 35));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        },
        () -> {
          JumbleJugglerException exception =
              assertThrows(
                  JumbleJugglerException.class,
                  () -> LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWords(16, -35));
          assertEquals("The integers provided should to be positive", exception.getMessage());
        });
  }
}
