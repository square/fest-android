// Copyright 2016 Square, Inc.
package org.assertj.android.preference.v7.api.preference;

import android.support.v7.preference.TwoStatePreference;

/**
 * Assertions for {@link TwoStatePreference} instances.
 * <p>
 * This class is final. To extend use {@link AbstractTwoStatePreference}.
 */
public final class TwoStatePreferenceAssert
    extends AbstractTwoStatePreference<TwoStatePreferenceAssert, TwoStatePreference>
{
  public TwoStatePreferenceAssert(TwoStatePreference actual) {
    super(actual, TwoStatePreferenceAssert.class);
  }
}
