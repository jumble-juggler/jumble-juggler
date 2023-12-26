/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler;

import io.github.jumblejuggler.exceptions.JumbleJugglerException;
import io.github.jumblejuggler.utils.LoremIpsumUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for generating random Lorem Ipsum text.
 *
 * <p>This class provides methods to generate random Lorem Ipsum sentences and paragraphs with
 * varying lengths and structures. It uses a predefined set of words obtained from {@link
 * LoremIpsumUtil}.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Generate a random sentence
 * try {
 *     String randomSentence = LoremIpsumJuggler.generateRandomSentence();
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Generate a random sentence with a specific number of words
 * try {
 *     String sentenceWithWords = LoremIpsumJuggler.generateRandomSentenceOfWords(15);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Generate a random paragraph
 * try {
 *     String randomParagraph = LoremIpsumJuggler.generateRandomParagraph();
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Generate a random paragraph with a specific number of sentences and words per sentence
 * try {
 *     String customParagraph = LoremIpsumJuggler.generateRandomParagraphWithSentencesOfWords(5, 12);
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 * }</pre>
 *
 * <p>The class uses the {@link IntegerJuggler} class and throws {@link JumbleJugglerException} for
 * invalid input parameters or if there is an issue during the randomization process.
 *
 * @see LoremIpsumUtil
 * @see IntegerJuggler
 * @see JumbleJugglerException
 */
public class LoremIpsumJuggler {
  private static final List<String> WORDS = LoremIpsumUtil.getInstance().getWords();
  private static final Character[] PUNCTUATIONS = {'.', '!', '?'};
  private static final int MIN_WORDS = 10;
  private static final int MAX_WORDS = 20;
  private static final int MIN_SENTENCES = 3;
  private static final int MAX_SENTENCES = 5;

  private LoremIpsumJuggler() {}

  /**
   * Method used to generate one Lorem Ipsum sentence containing a number of words between {@link
   * #MIN_WORDS} and {@link #MAX_WORDS}.
   *
   * @return the generated sentence as {@link String}
   * @throws JumbleJugglerException if the length of {@link #PUNCTUATIONS} is negative, which is not
   *     possible.
   * @see IntegerJuggler#generateRandomIntBetween(int, int)
   */
  public static String generateRandomSentence() throws JumbleJugglerException {
    return generateRandomParagraphWithSentencesOfWords(
        1, IntegerJuggler.generateRandomIntBetween(MIN_WORDS, MAX_WORDS));
  }

  /**
   * Method used to generate one Lorem Ipsum sentence composed of an amount of words specified by
   * {@code wordsNumber}.
   *
   * @param wordsNumber number of words in the sentence
   * @return the generated sentence as {@link String}
   * @throws JumbleJugglerException if {@code wordsNumber} is negative or equal to zero or the
   *     length of {@link #PUNCTUATIONS} is negative, which is not possible.
   */
  public static String generateRandomSentenceOfWords(int wordsNumber)
      throws JumbleJugglerException {
    if (wordsNumber <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException("The number of words provided needs to be positive"),
          LoremIpsumJuggler.class);
    }
    return generateRandomParagraphWithSentencesOfWords(1, wordsNumber);
  }

  /**
   * Method used to generate one Lorem Ipsum sentence composed of an amount of words between {@code
   * minWords} and {@code maxWords}.
   *
   * @param minWords minimum number of words in the sentence
   * @param maxWords maximum number of words in the sentence
   * @return the generated sentence as {@link String}
   * @throws JumbleJugglerException if {@code minWords} or {@code maxWords} are less or equal to
   *     zero or the length of {@link #PUNCTUATIONS} is negative, which is not possible.
   * @see IntegerJuggler#generateRandomIntBetween(int, int)
   */
  public static String generateRandomSentenceOfWordsBetween(int minWords, int maxWords)
      throws JumbleJugglerException {
    if (minWords <= 0 || maxWords <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException("The integers provided should to be positive"),
          LoremIpsumJuggler.class);
    }
    return generateRandomParagraphWithSentencesOfWords(
        1, IntegerJuggler.generateRandomIntBetween(minWords, maxWords));
  }

  /**
   * Method used to generate one Lorem Ipsum paragraph composed of an amount of sentences varying
   * between {@link #MIN_SENTENCES} and {@link #MAX_SENTENCES}. Each sentence containing an amount
   * between {@link #MIN_WORDS} and {@link #MAX_WORDS} words.
   *
   * @return the generated paragraph as {@link String}
   * @throws JumbleJugglerException if the length of {@link #PUNCTUATIONS} is negative, which is not
   *     possible.
   * @see IntegerJuggler#generateRandomIntBetween(int, int)
   */
  public static String generateRandomParagraph() throws JumbleJugglerException {
    return generateRandomParagraphWithSentencesOfWords(
        IntegerJuggler.generateRandomIntBetween(MIN_SENTENCES, MAX_SENTENCES),
        IntegerJuggler.generateRandomIntBetween(MIN_WORDS, MAX_WORDS));
  }

  /**
   * Method used to generate one Lorem Ipsum paragraph composed of an amount of sentences specified
   * by {@code sentencesNumber}. Each sentence contains an amount of words between {@link
   * #MIN_WORDS} and {@link #MAX_WORDS}.
   *
   * @param sentencesNumber number of sentences in the paragraph
   * @return the generated paragraph as {@link String}
   * @throws JumbleJugglerException if {@code sentencesNumber} is less or equal to zero or the
   *     length of {@link #PUNCTUATIONS} is negative, which is not possible.
   * @see IntegerJuggler#generateRandomIntBetween(int, int)
   */
  public static String generateRandomParagraphWithSentences(int sentencesNumber)
      throws JumbleJugglerException {
    if (sentencesNumber <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException("The number of sentences provided needs to be positive"),
          LoremIpsumJuggler.class);
    }

    return generateRandomParagraphWithSentencesOfWords(
        sentencesNumber, IntegerJuggler.generateRandomIntBetween(MIN_WORDS, MAX_WORDS));
  }

  /**
   * Generates one Lorem Ipsum paragraph composed of an amount of sentences varying between {@code
   * minSentences} and {@code maxSentences}. Each sentence contains an amount of words between
   * {@link #MIN_WORDS} and {@link #MAX_WORDS}.
   *
   * @param minSentences The minimum number of sentences in the paragraph.
   * @param maxSentences The maximum number of sentences in the paragraph.
   * @return The generated paragraph as {@link String}.
   * @throws JumbleJugglerException If {@code minSentences} or {@code maxSentences} is less than or
   *     equal to zero, or if the length of {@link #PUNCTUATIONS} is negative, which is not
   *     possible.
   * @see IntegerJuggler#generateRandomIntBetween(int, int)
   */
  public static String generateRandomParagraphWithSentencesBetween(
      int minSentences, int maxSentences) throws JumbleJugglerException {
    if (minSentences <= 0 || maxSentences <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException("The integers provided should to be positive"),
          LoremIpsumJuggler.class);
    }

    return generateRandomParagraphWithSentencesOfWords(
        IntegerJuggler.generateRandomIntBetween(minSentences, maxSentences),
        IntegerJuggler.generateRandomIntBetween(MIN_WORDS, MAX_WORDS));
  }

  /**
   * Generates one Lorem Ipsum paragraph composed of {@code sentencesNumber} amount of sentences.
   * Each sentence contains an amount of words between {@code minWords} and {@code maxWords}.
   *
   * @param sentencesNumber The number of sentences in the paragraph.
   * @param minWords The minimum number of words in each sentence.
   * @param maxWords The maximum number of words in each sentence.
   * @return The generated paragraph as {@link String}.
   * @throws JumbleJugglerException If {@code sentencesNumber}, {@code minWords}, or {@code
   *     maxWords} is less than or equal to zero, or if the length of {@link #PUNCTUATIONS} is
   *     negative, which is not possible.
   * @see IntegerJuggler#generateRandomIntBetween(int, int)
   */
  public static String generateRandomParagraphWithSentencesOfWordsBetween(
      int sentencesNumber, int minWords, int maxWords) throws JumbleJugglerException {
    if (sentencesNumber <= 0 || minWords <= 0 || maxWords <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException("The integers provided should to be positive"),
          LoremIpsumJuggler.class);
    }

    return generateRandomParagraphWithSentencesOfWords(
        sentencesNumber, IntegerJuggler.generateRandomIntBetween(minWords, maxWords));
  }

  /**
   * Generates one Lorem Ipsum paragraph composed of an amount of sentences varying between {@code
   * minSentences} and {@code maxSentences}. Each sentence contains an amount of words between
   * {@code minWords} and {@code maxWords}.
   *
   * @param minSentences The minimum number of sentences in the paragraph.
   * @param maxSentences The maximum number of sentences in the paragraph.
   * @param minWords The minimum number of words in each sentence.
   * @param maxWords The maximum number of words in each sentence.
   * @return The generated paragraph as {@link String}.
   * @throws JumbleJugglerException If {@code minSentences}, {@code maxSentences}, {@code minWords},
   *     or {@code maxWords} is less than or equal to zero, or if the length of {@link
   *     #PUNCTUATIONS} is negative, which is not possible.
   * @see IntegerJuggler#generateRandomIntBetween(int, int)
   */
  public static String generateRandomParagraphWithSentencesBetweenMadeOfWordsBetween(
      int minSentences, int maxSentences, int minWords, int maxWords)
      throws JumbleJugglerException {
    if (minSentences <= 0 || maxSentences <= 0 || minWords <= 0 || maxWords <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException("The integers provided should to be positive"),
          LoremIpsumJuggler.class);
    }

    return generateRandomParagraphWithSentencesOfWords(
        IntegerJuggler.generateRandomIntBetween(minSentences, maxSentences),
        IntegerJuggler.generateRandomIntBetween(minWords, maxWords));
  }

  /**
   * Method used to generate one Lorem Ipsum paragraph composed of {@code sentencesNumber} amount of
   * sentences. Each sentence contains {@code wordsNumber} amount of words.
   *
   * @param sentencesNumber number of sentences in the paragraph
   * @param wordsNumber number of words in each sentence
   * @return the generated sentence as {@link String}
   * @throws JumbleJugglerException if {@code sentencesNumber} or {@code wordsNumber} are less or
   *     equal to zero or the length of {@link #PUNCTUATIONS} is negative which is not possible
   */
  public static String generateRandomParagraphWithSentencesOfWords(
      int sentencesNumber, int wordsNumber) throws JumbleJugglerException {
    if (sentencesNumber <= 0 || wordsNumber <= 0) {
      throw new JumbleJugglerException(
          new IllegalArgumentException("The integers provided should to be positive"),
          LoremIpsumJuggler.class);
    }
    StringBuilder paragraph = new StringBuilder();

    for (int i = 0; i < sentencesNumber; i++) {
      List<StringBuilder> sentenceWords = getRandomWords(wordsNumber);
      paragraph.append(constructSentence(sentenceWords, i == sentencesNumber - 1)).append(" ");
    }

    return capitalizeTheFirstLetterOfSentence(paragraph);
  }

  private static List<StringBuilder> getRandomWords(int wordsNumber) throws JumbleJugglerException {
    List<StringBuilder> sentenceWords = new ArrayList<>();

    for (int i = 0; i < wordsNumber; i++) {
      sentenceWords.add(
          new StringBuilder()
              .append(
                  WORDS.get(IntegerJuggler.generateRandomPositiveIntSmallerThan(WORDS.size()))));
    }
    return sentenceWords;
  }

  private static String constructSentence(List<StringBuilder> sentenceWords, boolean isLastSentence)
      throws JumbleJugglerException {
    sentenceWords
        .get(sentenceWords.size() - 1)
        .append(
            sentenceWords.size() > IntegerJuggler.generateRandomIntBetween(3, 10) || isLastSentence
                ? "."
                : ",");

    StringBuilder sentence = new StringBuilder();
    for (StringBuilder sentenceWord : sentenceWords) {
      sentence.append(sentenceWord.toString()).append(" ");
    }

    // Remove the trailing space
    if (sentence.length() > 1) {
      sentence.setLength(sentence.length() - 1);
    }

    return sentence.toString();
  }

  private static String capitalizeTheFirstLetterOfSentence(StringBuilder paragraph)
      throws JumbleJugglerException {
    Pattern pattern = Pattern.compile("\\.\\s*\\w");
    Matcher matcher = pattern.matcher(capitalizeFirstLetterOfParagraph(paragraph));
    StringBuilder sb = new StringBuilder();

    while (matcher.find()) {
      String replacement =
          matcher
              .group()
              .toUpperCase()
              .replace(
                  '.',
                  PUNCTUATIONS[
                      IntegerJuggler.generateRandomPositiveIntSmallerThan(PUNCTUATIONS.length)]);
      matcher.appendReplacement(sb, replacement);
    }
    matcher.appendTail(sb);
    return sb.toString();
  }

  private static String capitalizeFirstLetterOfParagraph(StringBuilder paragraph) {
    return Character.toUpperCase(paragraph.charAt(0)) + paragraph.substring(1);
  }
}
