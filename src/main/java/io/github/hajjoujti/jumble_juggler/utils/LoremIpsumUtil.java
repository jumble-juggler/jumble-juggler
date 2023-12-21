/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.hajjoujti.jumble_juggler.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for managing Lorem Ipsum words.
 *
 * <p>This class follows the Singleton design pattern to ensure that only one instance is created
 * and shared across the application. It provides access to a list of Lorem Ipsum words that can be
 * loaded from an external JSON file.
 *
 * <p>To obtain an instance of this utility class, use the {@code getInstance()} method:
 *
 * <pre>{@code
 * LoremIpsumUtil loremIpsumUtil = LoremIpsumUtil.getInstance();
 * }</pre>
 *
 * <p>The list of Lorem Ipsum words can be accessed using the {@code getWords()} method:
 *
 * <pre>{@code
 * List<String> words = loremIpsumUtil.getWords();
 * }</pre>
 *
 * <p>The utility class loads the words lazily during the first access to the {@code getWords()}
 * method. If an error occurs while loading the words from the JSON file, a {@code RuntimeException}
 * is thrown.
 *
 * <p>The default file path for the JSON file is "src/main/java/resources/lorem-ipsum.json". If
 * needed, you can customize the file path by modifying the {@code filePath} variable in the code.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * LoremIpsumUtil loremIpsumUtil = LoremIpsumUtil.getInstance();
 * List<String> words = loremIpsumUtil.getWords();
 * // Use the words as needed
 * }</pre>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton Pattern</a>
 * @see <a href="https://github.com/FasterXML/jackson">Jackson ObjectMapper</a>
 */
public class LoremIpsumUtil {
  private static final Logger logger = Logger.getLogger(LoremIpsumUtil.class.getName());

  /** Static inner class to hold the single instance of {@link LoremIpsumUtil}. */
  private static class SingletonHolder {
    private static final LoremIpsumUtil INSTANCE = new LoremIpsumUtil();
  }

  private final List<String> words = new ArrayList<>();

  /**
   * Private constructor that loads words from the file.
   *
   * <p>It is called during the initialization of the singleton instance.
   */
  private LoremIpsumUtil() {
    try {
      loadWordsFromFile();
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
  public static LoremIpsumUtil getInstance() {
    return SingletonHolder.INSTANCE;
  }

  /**
   * Returns the non-empty list of Lorem Ipsum words.
   *
   * @return {@link #words}
   */
  public List<String> getWords() {
    return SingletonHolder.INSTANCE.words;
  }

  /**
   * Loads Lorem Ipsum words from the JSON file into {@link #words}.
   *
   * @throws IOException if an error occurred while reading the JSON file.
   */
  private void loadWordsFromFile() throws IOException {
    String filePath = "src/main/java/resources/lorem-ipsum.json";
    this.words.addAll(new ObjectMapper().readValue(new File(filePath), new TypeReference<>() {}));
  }
}
