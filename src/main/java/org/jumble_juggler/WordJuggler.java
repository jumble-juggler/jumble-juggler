/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package org.jumble_juggler;

import java.util.List;
import java.util.Map;
import org.jumble_juggler.exceptions.JumbleJugglerException;
import org.jumble_juggler.utils.WordsUtil;

/**
 * Utility class for randomizing English words.
 *
 * <p>This class provides methods to generate random English words and retrieve words based on
 * specific criteria. It uses a predefined list of English words and provides functionalities for
 * random selection.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * // Get a random English word
 * String randomWord = WordJuggler.getRandomDictionaryWord();
 *
 * // Get a random English word starting with a specific character
 * try {
 *     String wordStartingWithA = WordJuggler.getRandomDictionaryWordStartingWithCharacter('A');
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 *
 * // Get a random English word starting with a specific string
 * try {
 *     String wordStartingWithPrefix = WordJuggler.getRandomDictionaryWordStartingWithString("pre");
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 * }</pre>
 *
 * <p>The class relies on the {@link IntegerJuggler} class and throws {@link JumbleJugglerException}
 * for invalid input or if the requested words do not exist.
 *
 * @see IntegerJuggler
 * @see JumbleJugglerException
 */
public class WordJuggler {
  private static final List<String> words = WordsUtil.getInstance().getWords();
  private static final Map<Character, List<String>> wordsAlphabeticallyMap =
      WordsUtil.getInstance().getWordsSortedMap();

  /**
   * Generates and returns a random English word from the dictionary.
   *
   * @return A random English word as {@link String}.
   * @throws JumbleJugglerException If an error occurs during the randomization process.
   */
  public static String getRandomDictionaryWord() throws JumbleJugglerException {
    return words.get(IntegerJuggler.generateRandomPositiveIntSmallerThan(words.size()));
  }

  /**
   * Retrieves and returns a random English word starting with a specific character.
   *
   * @param character The character with which the word should start.
   * @return A random English word starting with the specified character as {@link String}.
   * @throws JumbleJugglerException If the specified character is not in the English alphabet or if
   *     no words start with the provided character.
   */
  public static String getRandomDictionaryWordStartingWithCharacter(char character)
      throws JumbleJugglerException {
    List<String> wordsStartingWithCharacter =
        wordsAlphabeticallyMap.get(Character.toUpperCase(character));

    if (wordsStartingWithCharacter != null && !wordsStartingWithCharacter.isEmpty()) {
      return wordsStartingWithCharacter.get(
          IntegerJuggler.generateRandomPositiveIntSmallerThan(wordsStartingWithCharacter.size()));
    }

    throw new JumbleJugglerException(
        String.format("The character \"%s\" given is not in the English alphabet", character),
        WordJuggler.class);
  }

  /**
   * Retrieves and returns a random English word starting with a specific string prefix.
   *
   * @param prefix The string prefix with which the word should start.
   * @return A random English word starting with the specified string prefix as {@link String}.
   * @throws JumbleJugglerException If no words start with the provided string prefix.
   */
  public static String getRandomDictionaryWordStartingWithString(String prefix)
      throws JumbleJugglerException {
    List<String> wordsStartingWithString =
        words.parallelStream().filter(word -> word.startsWith(prefix.toUpperCase())).toList();

    if (!wordsStartingWithString.isEmpty()) {
      return wordsStartingWithString.get(
          IntegerJuggler.generateRandomPositiveIntSmallerThan(wordsStartingWithString.size()));
    }
    throw new JumbleJugglerException(
        String.format("No Words start with \"%s\"", prefix), WordJuggler.class);
  }
}
