package org.fest.assertions.api.android;

import java.util.List;

public final class Utils {
  public static String join(List<String> parts) {
    StringBuilder builder = new StringBuilder();
    for (String part : parts) {
      if (builder.length() > 0) {
        builder.append(", ");
      }
      builder.append(part);
    }
    return builder.toString();
  }

  private Utils() {
    // No instances.
  }
}
