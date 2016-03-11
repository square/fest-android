// Copyright 2016 Square, Inc.
package org.assertj.android.preference.v7.api.preference;

import android.support.v7.preference.DialogPreference;

/**
 * Assertions for {@link DialogPreference} instances.
 * <p>
 * This class is final. To extend use {@link AbstractDialogPreferenceAssert}.
 */
public final class DialogPreferenceAssert
    extends AbstractDialogPreferenceAssert<DialogPreferenceAssert, DialogPreference> {
  public DialogPreferenceAssert(DialogPreference actual) {
    super(actual, DialogPreferenceAssert.class);
  }
}
