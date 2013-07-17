package org.fest.assertions.api.android.content;

import android.content.Intent;
import android.net.Uri;
import org.fest.assertions.api.AbstractAssert;
import org.fest.assertions.api.android.util.BitMaskStringBuilder;

import static android.content.Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
import static android.content.Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS;
import static android.content.Intent.FLAG_ACTIVITY_FORWARD_RESULT;
import static android.content.Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY;
import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;
import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;
import static android.content.Intent.FLAG_ACTIVITY_NO_USER_ACTION;
import static android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;
import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
import static android.content.Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;
import static android.content.Intent.FLAG_ACTIVITY_TASK_ON_HOME;
import static android.content.Intent.FLAG_DEBUG_LOG_RESOLUTION;
import static android.content.Intent.FLAG_FROM_BACKGROUND;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;
import static android.content.Intent.FLAG_RECEIVER_REGISTERED_ONLY;
import static org.fest.assertions.api.Assertions.assertThat;

/** Assertions for {@link Intent} instances. */
public class IntentAssert extends AbstractAssert<IntentAssert, Intent> {
  public IntentAssert(Intent actual) {
    super(actual, IntentAssert.class);
  }

  public IntentAssert hasAction(String action) {
    isNotNull();
    String actualAction = actual.getAction();
    assertThat(actualAction) //
        .overridingErrorMessage("Expected action <%s> but was <%s>.", action, actualAction) //
        .isEqualTo(action);
    return this;
  }

  public IntentAssert hasType(String type) {
    isNotNull();
    String actualType = actual.getType();
    assertThat(actualType) //
        .overridingErrorMessage("Expected type <%s> but was <%s>.", type, actualType) //
        .isEqualTo(type);
    return this;
  }

  public IntentAssert hasExtra(String name) {
    isNotNull();
    assertThat(actual.hasExtra(name)) //
        .overridingErrorMessage("Expected extra <%s> to be present but was not present.", name) //
        .isTrue();
    return this;
  }

  public IntentAssert hasFlags(int flags) {
    int expected = actual.getFlags();
    assertThat(expected).overridingErrorMessage("Expected <%s> but was <%s>.",
        flagsToString(expected), flagsToString(flags)).isEqualTo(flags);
    return this;
  }

  public IntentAssert hasData(String uri) {
    return hasData(Uri.parse(uri));
  }

  public IntentAssert hasData(Uri uri) {
    Uri actualUri = actual.getData();
    assertThat(actualUri.compareTo(uri)) //
        .overridingErrorMessage("Expected data Uri <%s> but was <%s>.", uri, actualUri)
        .isEqualTo(0);
    return this;
  }

  public static String flagsToString(int flags) {
    return new BitMaskStringBuilder(flags) //
        .flag(FLAG_GRANT_READ_URI_PERMISSION, "grant_read_uri_permission")
        .flag(FLAG_GRANT_WRITE_URI_PERMISSION, "grant_write_uri_permission")
        .flag(FLAG_DEBUG_LOG_RESOLUTION, "debug_log_resolution")
        .flag(FLAG_FROM_BACKGROUND, "from_background")
        .flag(FLAG_ACTIVITY_BROUGHT_TO_FRONT, "activity_brought_to_front")
        .flag(FLAG_ACTIVITY_CLEAR_TASK, "activity_clear_task")
        .flag(FLAG_ACTIVITY_CLEAR_TOP, "activity_clear_top")
        .flag(FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET, "activity_clear_when_task_reset")
        .flag(FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS, "activity_exclude_from_recents")
        .flag(FLAG_ACTIVITY_FORWARD_RESULT, "activity_forward_result")
        .flag(FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY, "activity_launched_from_history")
        .flag(FLAG_ACTIVITY_MULTIPLE_TASK, "activity_multiple_task")
        .flag(FLAG_ACTIVITY_NEW_TASK, "activity_new_task")
        .flag(FLAG_ACTIVITY_NO_ANIMATION, "activity_no_animation")
        .flag(FLAG_ACTIVITY_NO_HISTORY, "activity_no_history")
        .flag(FLAG_RECEIVER_REGISTERED_ONLY, "receiver_registered_only")
        .flag(FLAG_ACTIVITY_NO_USER_ACTION, "activity_no_user_action")
        .flag(FLAG_ACTIVITY_PREVIOUS_IS_TOP, "activity_previous_is_top")
        .flag(FLAG_ACTIVITY_RESET_TASK_IF_NEEDED, "activity_reset_task_if")
        .flag(FLAG_ACTIVITY_REORDER_TO_FRONT, "activity_reorder_to_front")
        .flag(FLAG_ACTIVITY_SINGLE_TOP, "activity_single_top")
        .flag(FLAG_ACTIVITY_TASK_ON_HOME, "activity_task_on_home")
        .get();
  }
}
