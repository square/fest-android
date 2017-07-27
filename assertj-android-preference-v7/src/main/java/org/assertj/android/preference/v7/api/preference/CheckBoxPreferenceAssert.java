// Copyright 2016 Square, Inc.
package org.assertj.android.preference.v7.api.preference;

import android.support.v7.preference.CheckBoxPreference;

/** Assertions for {@link CheckBoxPreference} instances. */
public class CheckBoxPreferenceAssert
    extends AbstractTwoStatePreference<CheckBoxPreferenceAssert, CheckBoxPreference>
{
  /* Since TwoStatePreference is ICS+ this class allows CheckBoxPreference asserts on pre-ICS. */
  public CheckBoxPreferenceAssert(CheckBoxPreference actual) {
    super(actual, CheckBoxPreferenceAssert.class);
  }
}
