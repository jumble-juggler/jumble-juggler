/**
* @author h@jjoujti
* Copyright (C)2023. All rights reserved.
* This code is licensed under the MIT License.
*/
package io.github.jumblejuggler.exceptions;

import java.util.logging.Logger;

/**
 * Exception class specific to the JumbleJuggler utility.
 *
 * <p>This exception is thrown to indicate errors related to the JumbleJuggler utility. It extends
 * {@link RuntimeException} to allow for unchecked exceptions.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * try {
 *     // Code that may throw JumbleJugglerException
 * } catch (JumbleJugglerException e) {
 *     // Handle exception
 * }
 * }</pre>
 *
 * <p>The class logs the exception message using the Java Logger associated with the provided class.
 *
 * @see RuntimeException
 */
public class JumbleJugglerException extends RuntimeException {
  /**
   * Constructs a new JumbleJugglerException with the specified error message and associated class.
   *
   * @param message The error message.
   * @param aClass The class associated with the exception.
   */
  public JumbleJugglerException(String message, Class<?> aClass) {
    super(message);
    Logger.getLogger(aClass.getName()).severe(message);
  }

  /**
   * Constructs a new JumbleJugglerException with the specified throwable and associated class.
   *
   * @param throwable The throwable object.
   * @param aClass The class associated with the exception.
   */
  public JumbleJugglerException(Throwable throwable, Class<?> aClass) {
    super(throwable.getMessage(), throwable);
    Logger.getLogger(aClass.getName()).severe(throwable.getMessage());
  }
}
