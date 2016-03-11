// Copyright 2016 Square, Inc.
package org.assertj.android.preference.v7.api.preference;

import android.annotation.TargetApi;
import android.support.v7.preference.SwitchPreferenceCompat;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static org.assertj.core.api.Assertions.assertThat;

/** Assertions for {@link SwitchPreferenceCompat} instances. */
@TargetApi(ICE_CREAM_SANDWICH)
public class SwitchPreferenceCompatAssert
    extends AbstractTwoStatePreference<SwitchPreferenceCompatAssert, SwitchPreferenceCompat> {
  public SwitchPreferenceCompatAssert(SwitchPreferenceCompat actual) {
    super(actual, SwitchPreferenceCompatAssert.class);
  }

  public SwitchPreferenceCompatAssert hasSwitchTextOff(CharSequence text) {
    isNotNull();
    CharSequence actualText = actual.getSwitchTextOff();
    assertThat(actualText) //
        .overridingErrorMessage("Expected switch off text <%s> but was <%s>.", text, actualText) //
        .isEqualTo(text);
    return this;
  }

  public SwitchPreferenceCompatAssert hasSwitchTextOff(int resId) {
    isNotNull();
    return hasSwitchTextOff(actual.getContext().getString(resId));
  }

  public SwitchPreferenceCompatAssert hasSwitchTextOn(CharSequence text) {
    isNotNull();
    CharSequence actualText = actual.getSwitchTextOn();
    assertThat(actualText) //
        .overridingErrorMessage("Expected switch on text <%s> but was <%s>.", text, actualText) //
        .isEqualTo(text);
    return this;
  }

  public SwitchPreferenceCompatAssert hasSwitchTextOn(int resId) {
    isNotNull();
    return hasSwitchTextOn(actual.getContext().getString(resId));
  }
}
