/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for managing dictionary words.
 *
 * <p>This class follows the Singleton design pattern to ensure that only one instance is created
 * and shared across the application. It provides access to a list of dictionary words that can be
 * loaded from an external JSON file. Additionally, it constructs a map where words are grouped
 * alphabetically based on their starting letter.
 *
 * <p>To obtain an instance of this utility class, use the {@code getWords()} and {@code
 * getWordsSortedMap()} methods:
 *
 * <pre>{@code
 * List<String> words = WordsUtil.getWords();
 * Map<Character, List<String>> wordsMap = WordsUtil.getWordsSortedMap();
 * }</pre>
 *
 * <p>The utility class loads the words lazily during the first access to the {@code getWords()}
 * method. If an error occurs while loading the words from the JSON file, a {@code RuntimeException}
 * is thrown.
 *
 * <p>The default file path for the JSON file is "src/main/java/resources/words.json". If needed,
 * you can customize the file path by modifying the {@code filePath} variable in the code.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * List<String> words = WordsUtil.getWords();
 * Map<Character, List<String>> wordsMap = WordsUtil.getWordsSortedMap();
 * // Use the words and map as needed
 * }</pre>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton Pattern</a>
 * @see <a href="https://github.com/FasterXML/jackson">Jackson ObjectMapper</a>
 */
public class WordsUtil {
  private static final Logger logger = Logger.getLogger(WordsUtil.class.getName());

  /** Static inner class to hold the single instance of {@link WordsUtil}. */
  private static class SingletonHolder {
    private static final WordsUtil INSTANCE = new WordsUtil();
  }

  private final List<String> words = new ArrayList<>();
  private final Map<Character, List<String>> wordsAlphabeticallyMap = new HashMap<>();

  /**
   * Private constructor that loads words from the file and builds the words map.
   *
   * <p>It associates each word with its starting letter in the {@link #wordsAlphabeticallyMap}.
   */
  private WordsUtil() {
    try {
      loadWordsFromFile();
      this.words.forEach(
          word ->
              this.wordsAlphabeticallyMap
                  .computeIfAbsent(Character.toUpperCase(word.charAt(0)), k -> new ArrayList<>())
                  .add(word));
    } catch (IOException e) {
      logger.log(Level.SEVERE, e.getMessage(), e);
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns the singleton instance of {@link LoremIpsumUtil}.
   *
   * @return {@link LoremIpsumUtil}
   */
  public static WordsUtil getInstance() {
    return WordsUtil.SingletonHolder.INSTANCE;
  }

  /**
   * Returns the non-empty list of dictionary words.
   *
   * @return {@link #words}
   */
  public List<String> getWords() {
    return SingletonHolder.INSTANCE.words;
  }

  /**
   * Returns the non-empty map of dictionary words where keys are the English alphabet letters and
   * values are lists of words starting with the corresponding letter.
   *
   * @return {@link #wordsAlphabeticallyMap}
   */
  public Map<Character, List<String>> getWordsSortedMap() {
    return SingletonHolder.INSTANCE.wordsAlphabeticallyMap;
  }

  /**
   * Loads dictionary words from the JSON file into {@link #words}.
   *
   * @throws IOException if an error occurred while reading the JSON file.
   */
  private void loadWordsFromFile() throws IOException {
    String filePath = "src/main/java/resources/words.json";
    this.words.addAll(new ObjectMapper().readValue(new File(filePath), new TypeReference<>() {}));
  }
}
