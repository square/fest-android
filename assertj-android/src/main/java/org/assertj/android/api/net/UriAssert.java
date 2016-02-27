package org.assertj.android.api.net;

import android.net.Uri;

import org.assertj.core.api.AbstractAssert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class UriAssert
        extends AbstractAssert<UriAssert, Uri>
        implements UriAssertions<UriAssert> {

    public UriAssert(Uri actual) {
        super(actual, UriAssert.class);
    }

    /*
     * NOTE: any methods added to this class should also be added to
     * UriAssertions, and equivalent proxy methods added to
     * UriQueryParamAssert.
     */

    @Override
    public UriAssert hasPath(String path) {
        isNotNull();
        String actualPath = actual.getPath();
        assertThat(actualPath) //
            .overridingErrorMessage("Expected path <%s> but was <%s>.", path, actualPath) //
            .isEqualTo(path);

        return this;
    }

    /**
     * @deprecated parameter was never used. Use {@link #hasNoPath()} instead.
     */
    @Deprecated
    public UriAssert hasNoPath(String action) {
        return hasNoPath();
    }

    @Override
    public UriAssert hasNoPath() {
        isNotNull();
        String actualPath = actual.getPath();
        assertThat(actualPath)
            .overridingErrorMessage("Expected no path but was <%s>.", actualPath)
            .isNull();
        return this;
    }

    @Override
    public UriAssert hasPort(int port) {
        isNotNull();
        int actualPort = actual.getPort();
        assertThat(actualPort)
            .overridingErrorMessage("Expected port <%d> but was <%s>.", port, actualPort)
            .isEqualTo(port);
        return this;
    }

    @Override
    public UriAssert hasHost(String host) {
        isNotNull();
        String actualHost = actual.getHost();
        assertThat(actualHost)
            .overridingErrorMessage("Expected host <%s> but was <%s>.", host, actualHost)
            .isEqualTo(host);
        return this;
    }

    @Override
    public UriAssert hasFragment(String fragment) {
        isNotNull();
        String actualFragment = actual.getFragment();
        assertThat(actualFragment)
            .overridingErrorMessage("Expected fragment <%s> but was <%s>.", fragment, actualFragment)
            .isEqualTo(fragment);
        return this;
    }

    @Override
    public UriAssert hasNoFragment() {
        isNotNull();
        String actualFragment = actual.getFragment();
        assertThat(actualFragment)
            .overridingErrorMessage("Expected no fragment but was <%s>.", actualFragment)
            .isNull();
        return this;
    }

    @Override
    public UriAssert hasQuery(String query) {
        isNotNull();
        String actualQuery = actual.getQuery();
        assertThat(actualQuery)
            .overridingErrorMessage("Expected query <%s> but was <%s>.", query, actualQuery)
            .isEqualTo(query);
        return this;
    }

    @Override
    public UriAssert hasNoQuery() {
        isNotNull();
        String actualQuery = actual.getQuery();
        assertThat(actual.getQuery())
            .overridingErrorMessage("Expected no query but was <%s>.", actualQuery)
            .isNull();
        return this;
    }

    @Override
    public UriAssert hasScheme(String scheme) {
        isNotNull();
        String actualScheme = actual.getScheme();
        assertThat(actualScheme)
            .overridingErrorMessage("Expected scheme <%s> but was <%s>.", scheme, actualScheme)
            .isEqualTo(scheme);
        return this;
    }

    @Override
    public UriAssert hasUserInfo(String userInfo) {
        isNotNull();
        String actualUserInfo = actual.getUserInfo();
        assertThat(actualUserInfo)
            .overridingErrorMessage("Expected userInfo <%s> but was <%s>.", userInfo, actualUserInfo)
            .isEqualTo(userInfo);
        return this;
    }

    @Override
    public UriAssert hasNoUserInfo() {
        isNotNull();
        String actualUserInfo = actual.getUserInfo();
        assertThat(actualUserInfo)
            .overridingErrorMessage("Expected no userInfo but was <%s>.", actualUserInfo)
            .isNull();
        return this;
    }

    @Override
    public UriAssert hasAuthority(String authority) {
        isNotNull();
        String actualAuthority = actual.getAuthority();
        assertThat(actualAuthority)
                .overridingErrorMessage("Expected authority <%s> but was <%s>",
                        authority,
                        actualAuthority)
                .isEqualTo(authority);
        return this;
    }

    @Override
    public UriAssert hasQueryParameters(String... params) {
        isNotNull();

        for (String param : params) {
            assertThat(actual.getQueryParameter(param))
                    .overridingErrorMessage("Expected query parameter <%s> to be defined",
                            param)
                    .isNotNull();
        }
        return this;
    }

    @Override
    public UriQueryParamAssert hasQueryParameter(String param) {
        isNotNull();

        List<String> actualValues = actual.getQueryParameters(param);
        assertThat(actualValues)
                .overridingErrorMessage("Expected query parameter <%s> to be defined", param)
                .isNotEmpty();

        return new UriQueryParamAssert(this, actual, param, actualValues);
    }
}
