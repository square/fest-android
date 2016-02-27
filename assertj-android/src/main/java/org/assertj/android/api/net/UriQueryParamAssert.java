package org.assertj.android.api.net;

import android.net.Uri;

import org.assertj.core.api.AbstractAssert;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Wrapper of {@link UriAssert} that adds methods assert a property (once)
 * on the value of a query parameter, without disrupting the normal usage
 * of UriAssert. For example:
 *
 * <code>
 *     assertThat(uri)
 *         .hasQueryParameter("user").withValue("bob@example.com")
 *         .hasQueryParameter("married")
 *         .hasQueryParameter("pets").withValues("Spot", "Daisy");
 * </code>
 *
 * The interface specifically does not allow multiple asserts on the value, so that it
 * to avoid confusion about where the assertions on the value end and the the assertions
 * on the URI resume. For example:
 *
 * <code>
 *     assertThat(uri)
 *         .hasQueryParameter("dog")
 *             .withValue("dachshund")
 *             .withValue("labrador") // INVALID - method is no longer available
 *         .hasQueryParameter("cat")
 * </code>
 *
 * @see UriAssert#hasQueryParameter(String)
 */
public final class UriQueryParamAssert
        extends AbstractAssert<UriQueryParamAssert, Uri>
        implements UriAssertions {

    private final UriAssert parent;
    private final String paramName;
    private final List<String> actualValues;

    public UriQueryParamAssert(
            UriAssert parent,
            Uri actualUri,
            String paramName,
            List<String> actualValues) {
        super(actualUri, UriQueryParamAssert.class);
        this.parent = parent;
        this.paramName = paramName;
        this.actualValues = actualValues;
    }

    public UriAssert withValue(String value) {
        assertThat(actualValues)
                .overridingErrorMessage(
                        "Expected query parameter <%s> to have single value <%s>, "
                                + "but has multiple values: <%s>",
                        paramName,
                        value,
                        actualValues)
                .hasSize(1);

        assertThat(actualValues)
                .overridingErrorMessage(
                        "Expected query parameter <%s> to have value <%s>, but was <%s>",
                        paramName, value, actualValues.get(0))
                .isEqualTo(value);
        return parent;
    }

    public UriAssert withValues(String... values) {
        // use TreeSets for consistent ordering
        Set<String> actualValuesSet = new TreeSet<>(actualValues);
        Set<String> valuesSet = new TreeSet<>(Arrays.asList(values));
        assertThat(valuesSet)
                .overridingErrorMessage(
                        "Expected query parameter <%s> to have values <%s>, but was <%s>",
                        paramName,
                        valuesSet,
                        actualValuesSet)
                .isEqualTo(valuesSet);
        return parent;
    }

    // all other methods are proxies to the parent

    @Override
    public UriAssert hasPath(String path) {
        return parent.hasPath(path);
    }

    @Override
    public UriAssert hasNoPath() {
        return parent.hasNoPath();
    }

    @Override
    public UriAssert hasPort(int port) {
        return parent.hasPort(port);
    }

    @Override
    public UriAssert hasHost(String host) {
        return parent.hasHost(host);
    }

    @Override
    public UriAssert hasFragment(String fragment) {
        return parent.hasFragment(fragment);
    }

    @Override
    public UriAssert hasNoFragment() {
        return parent.hasNoFragment();
    }

    @Override
    public UriAssert hasQuery(String query) {
        return parent.hasQuery(query);
    }

    @Override
    public UriAssert hasNoQuery() {
        return parent.hasNoQuery();
    }

    @Override
    public UriAssert hasScheme(String scheme) {
        return parent.hasScheme(scheme);
    }

    @Override
    public UriAssert hasUserInfo(String userInfo) {
        return parent.hasUserInfo(userInfo);
    }

    @Override
    public UriAssert hasNoUserInfo() {
        return parent.hasNoUserInfo();
    }

    @Override
    public UriAssert hasAuthority(String authority) {
        return parent.hasAuthority(authority);
    }

    @Override
    public UriQueryParamAssert hasQueryParameter(String param) {
        return parent.hasQueryParameter(param);
    }

    @Override
    public UriAssert hasQueryParameters(String... params) {
        return parent.hasQueryParameters(params);
    }
}
