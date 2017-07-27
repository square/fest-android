// Copyright 2016 Square, Inc.
package org.assertj.android.preference.v7.api.preference;

import android.support.v7.preference.Preference;

/**
 * Assertions for {@link Preference} instances.
 * <p>
 * This class is final. To extend use {@link AbstractPreferenceAssert}.
 */
public final class PreferenceAssert extends AbstractPreferenceAssert<PreferenceAssert, Preference> {
  public PreferenceAssert(Preference actual) {
    super(actual, PreferenceAssert.class);
  }
}
