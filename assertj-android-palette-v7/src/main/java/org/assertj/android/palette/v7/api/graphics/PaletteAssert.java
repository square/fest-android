package org.assertj.android.palette.v7.api.graphics;

import android.support.v7.graphics.Palette;

import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Assertions for {@link Palette} instances.
 */
public class PaletteAssert extends AbstractAssert<PaletteAssert, Palette> {
  public PaletteAssert(Palette actual) {
    super(actual, PaletteAssert.class);
  }

  public PaletteAssert hasVibrantColor(int color) {
    isNotNull();
    int actualColor = actual.getVibrantColor(0);
    assertThat(equals(color, actualColor)) //
        .overridingErrorMessage("Expected vibrant color <%s> but was <%s>", color, actualColor) //
        .isTrue();
    return this;
  }

  public PaletteAssert hasDarkVibrantColor(int color) {
    isNotNull();
    int actualColor = actual.getDarkVibrantColor(0);
    assertThat(equals(color, actualColor)) //
        .overridingErrorMessage("Expected dark vibrant color <%s> but was <%s>", color, actualColor) //
        .isTrue();
    return this;
  }

  public PaletteAssert hasLightVibrantColor(int color) {
    isNotNull();
    int actualColor = actual.getLightVibrantColor(0);
    assertThat(equals(color, actualColor)) //
        .overridingErrorMessage("Expected light vibrant color <%s> but was <%s>", color, actualColor) //
        .isTrue();
    return this;
  }

  public PaletteAssert hasMutedColor(int color) {
    isNotNull();
    int actualColor = actual.getMutedColor(0);
    assertThat(equals(color, actualColor)) //
        .overridingErrorMessage("Expected muted color <%s> but was <%s>", color, actualColor) //
        .isTrue();
    return this;
  }

  public PaletteAssert hasDarkMutedColor(int color) {
    isNotNull();
    int actualColor = actual.getDarkMutedColor(0);
    assertThat(equals(color, actualColor)) //
        .overridingErrorMessage("Expected dark muted color <%s> but was <%s>", color, actualColor) //
        .isTrue();
    return this;
  }

  public PaletteAssert hasLightMutedColor(int color) {
    isNotNull();
    int actualColor = actual.getLightMutedColor(0);
    assertThat(equals(color, actualColor)) //
        .overridingErrorMessage("Expected light muted color <%s> but was <%s>", color, actualColor) //
        .isTrue();
    return this;
  }

  private static boolean equals(int actualColor, int color) {
    return actualColor == color;
  }
}
