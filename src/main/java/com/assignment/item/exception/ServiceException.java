package com.assignment.item.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * The Service Exception.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = -1552617640040732073L;
  /** The Constant serialVersionUID. */

  /**
   * The HTTP status.
   */
  private final HttpStatus httpStatus;

  /**
   * Additional Parameters
   */
  private final Map<String, Object> params = new HashMap<>();

  /**
   * Instantiates a new service exception.
   *
   * @param errorMessage the error message
   * @param httpStatus   the HTTP status
   */
  public ServiceException(final String errorMessage, final HttpStatus httpStatus) {
    super(errorMessage);
    this.httpStatus = httpStatus;
  }

  /**
   * Instantiates a new service exception.
   *
   * @param throwable the throwable
   */
  public ServiceException(final Throwable throwable, final HttpStatus httpStatus) {
    super(throwable);
    this.httpStatus = httpStatus;
  }

  @Override
  public String getMessage() {
    final StringBuilder sb = new StringBuilder(super.getMessage());
    this.params.forEach((k, v) -> {
      sb.append(k).append(" ").append(":").append(" ").append(v);
    });
    return sb.toString();
  }
}
