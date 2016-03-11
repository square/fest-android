// Copyright 2016 Square, Inc.
package org.assertj.android.preference.v7.api.preference;

import android.support.v7.preference.EditTextPreference;
import static org.assertj.core.api.Assertions.assertThat;

/** Assertions for {@link EditTextPreference} instances. */
public class EditTextPreferenceAssert
    extends AbstractDialogPreferenceAssert<EditTextPreferenceAssert, EditTextPreference> {
  public EditTextPreferenceAssert(EditTextPreference actual) {
    super(actual, EditTextPreferenceAssert.class);
  }

  public EditTextPreferenceAssert hasText(String text) {
    isNotNull();
    String actualText = actual.getText();
    assertThat(actualText) //
        .overridingErrorMessage("Expected text <%s> but was <%s>.", text, actualText) //
        .isEqualTo(text);
    return this;
  }
}
