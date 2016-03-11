// Copyright 2016 Square, Inc.
package org.assertj.android.preference.v7.api.preference;

import android.support.v7.preference.PreferenceGroup;

/**
 * Assertions for {@link PreferenceGroup} instances.
 * <p>
 * This class is final. To extend use {@link AbstractPreferenceGroupAssert}.
 */
public final class PreferenceGroupAssert
    extends AbstractPreferenceGroupAssert<PreferenceGroupAssert, PreferenceGroup> {
  public PreferenceGroupAssert(PreferenceGroup actual) {
    super(actual, PreferenceGroupAssert.class);
  }
}
